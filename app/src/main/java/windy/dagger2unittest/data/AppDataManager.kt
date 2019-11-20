package windy.dagger2unittest.data

import io.reactivex.Flowable
import windy.dagger2unittest.data.local.db.DBService
import windy.dagger2unittest.data.local.file.FileService
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.data.remote.RemoteService
import windy.dagger2unittest.di.scope.AppScope
import javax.inject.Inject

/**
 * @trinh.binh on 16/10/2018
 */
@AppScope
class AppDataManager : DataManager {

    @Inject
    lateinit var dbService: DBService
    @Inject
    lateinit var remoteService: RemoteService
    @Inject
    lateinit var fileService: FileService

    @Inject
    constructor()

    override fun getListUser(): Flowable<List<User>> {
        return remoteService.getListUser()
            .doOnNext {
                if (it.isNotEmpty()) {
                    saveToSharedPreference(it[0])
                }
            }
    }

    override fun saveUser(user: User) {
        dbService.saveUser(user)
    }

    override fun getNumber(): Int {
        return 100
    }

    private fun saveToSharedPreference(user: User) {
        fileService.addString("user_name", user.name)
    }
}