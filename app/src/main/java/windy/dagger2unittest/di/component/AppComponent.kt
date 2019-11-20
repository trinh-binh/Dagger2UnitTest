package windy.dagger2unittest.di.component

import android.content.Context
import dagger.Component
import windy.dagger2unittest.data.DataManager
import windy.dagger2unittest.di.module.AppModule
import windy.dagger2unittest.di.module.MainModule
import windy.dagger2unittest.di.scope.AppScope

/**
 * @trinh.binh on 17/01/2018
 */
@Component(modules = [AppModule::class])
@AppScope
interface AppComponent{
    fun createMainComponent(mainModule: MainModule): MainComponent
    fun getAppContext(): Context
    fun getDataManager() : DataManager
}