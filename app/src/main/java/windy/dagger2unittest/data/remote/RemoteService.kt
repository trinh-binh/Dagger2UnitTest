package windy.dagger2unittest.data.remote

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User

/**
 * @trinh.binh on 19/07/2018
 */
interface RemoteService {
    fun getListUser(): Flowable<List<User>>
}