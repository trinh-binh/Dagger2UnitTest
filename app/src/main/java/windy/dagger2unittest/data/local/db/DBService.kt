package windy.dagger2unittest.data.local.db

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User

/**
 * @trinh.binh on 19/07/2018
 */
interface DBService {
    fun saveUser(user: User)
    fun getLocalUser() : Flowable<List<User>>
}