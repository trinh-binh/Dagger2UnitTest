package windy.dagger2unittest.di.module

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import windy.dagger2unittest.app.App
import windy.dagger2unittest.app.Config
import windy.dagger2unittest.data.DataManager
import windy.dagger2unittest.data.AppDataManager
import windy.dagger2unittest.data.local.db.AppDBService
import windy.dagger2unittest.data.local.db.DBService
import windy.dagger2unittest.data.local.db.room.AppDatabase
import windy.dagger2unittest.data.local.file.AppSharedPreference
import windy.dagger2unittest.data.local.file.FileService
import windy.dagger2unittest.data.remote.http.ApiService
import windy.dagger2unittest.data.remote.AppRemoteService
import windy.dagger2unittest.data.remote.RemoteService
import windy.dagger2unittest.data.remote.http.FakeApiService
import windy.dagger2unittest.di.scope.AppScope
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Named

/**
 * @trinh.binh on 17/01/2018
 */
@Module
class AppModule(_app: App) {
    var app: App = _app

    @Provides
    @AppScope
    fun provideContext(): Context{
        return app
    }

    @Provides
    @AppScope
    fun provideSharePreference(): FileService{
        return AppSharedPreference(app)
    }

    @Provides
    fun provideExecutor(): Executor{
        return Executors.newSingleThreadExecutor()
    }

    @Provides
    @AppScope
    fun provideAppDatabase(): AppDatabase {
        return AppDatabase.getInstance(app)
    }

    @Provides
    @AppScope
    fun provideDBService(db: AppDBService) : DBService{
        return db
    }

    @Provides
    @Named("fake_api_service")
    fun provideFakeApiService() : ApiService{
        return FakeApiService()
    }

    @Provides
    @AppScope
    fun provideRemoteService(remote: AppRemoteService): RemoteService {
        return remote
    }

    @Provides
    @AppScope
    @Named("api_service")
    fun provideApiService() : ApiService{
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            //Log.d("okHttp", message)
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val headerInterceptor = object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val builder = original.newBuilder()
                val token = provideSharePreference().getString("token","")
                if(token == "" || token.isEmpty()) {
                    return chain.proceed(original)
                } else {
                    builder.addHeader("Authorization", token)
                    builder.method(original.method(), original.body())
                    return chain.proceed(builder.build())
                }
            }
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .addInterceptor(interceptor)
            .build()
        val gson = GsonBuilder().disableHtmlEscaping().create()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Config.BASE_URL)
            .build()
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @AppScope
    fun provideAppDataManager(data: AppDataManager): DataManager {
        return data
    }

/*    @Provides
    @Singleton
    fun provideAppDataManager(preference: FileService, dbService: AppDBService,
                              networkService: AppRemoteService): DataManager {
        return AppDataManager.createInstance(preference, dbService, networkService)
    }*/

}