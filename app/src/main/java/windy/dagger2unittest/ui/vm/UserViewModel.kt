package windy.dagger2unittest.ui.vm

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.ui.base.vm.BaseViewModel

/**
 *@trinh.binh on 13/10/2018
 */
class UserViewModel : BaseViewModel() {

    fun getListUser() : Flowable<List<User>>{
        return dataManager.getListUser()
    }

    fun getNumber(): Int{
        return dataManager.getNumber() + 10
    }
}