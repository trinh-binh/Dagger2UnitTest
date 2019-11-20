package windy.dagger2unittest.data

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User

/**
 *@trinh.binh on 16/01/2018
 *
 */
interface DataManager{
    fun getListUser() : Flowable<List<User>>
    fun saveUser(user: User)
    fun getNumber(): Int
}