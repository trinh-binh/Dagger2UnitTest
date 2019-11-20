package windy.dagger2unittest.ui.vm

import android.arch.lifecycle.ViewModel
import io.reactivex.Flowable
import windy.dagger2unittest.data.DataManager
import windy.dagger2unittest.data.model.User
import javax.inject.Inject

/**
 *@trinh.binh on 15/11/2019
 */
class GodUserViewModel : ViewModel {
    @Inject
    lateinit var dataManager: DataManager

    @Inject
    constructor()

    fun getListUser() : Flowable<List<User>> {
        return dataManager.getListUser()
    }

    fun getNumber(): Int{
        return dataManager.getNumber() + 10
    }

}