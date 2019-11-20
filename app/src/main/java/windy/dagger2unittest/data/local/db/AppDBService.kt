package windy.dagger2unittest.data.local.db

import android.util.Log
import io.reactivex.Flowable
import windy.dagger2unittest.data.local.db.room.AppDatabase
import windy.dagger2unittest.data.local.db.room.UserEntity
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.di.scope.AppScope
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @trinh.binh on 19/07/2018
 */
@AppScope
class AppDBService : DBService {
    private var database: AppDatabase
    private var executor: Executor
    @Inject
    constructor(db : AppDatabase, ex: Executor){
        database = db
        executor = ex
    }

    override fun saveUser(user: User) {
        var userEntity = UserEntity()
        userEntity.id = user.id
        userEntity.name = user.name
        executor.execute(Runnable {
            Log.d("windy.f","save user '${user.name}' to database ")
            database.getUserDao().insertUser(userEntity) //do not need
        })

    }

    override fun getLocalUser(): Flowable<List<User>> {
        return database.getUserDao().getTop10User()
            .map {
                var list = ArrayList<User>()
                for(user in it){
                    list.add(User(user.id, user.name))
                }
                list
            }
    }
}