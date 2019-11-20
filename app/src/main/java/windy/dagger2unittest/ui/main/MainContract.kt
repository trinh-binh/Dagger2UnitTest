package windy.dagger2unittest.ui.main

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.ui.base.BasePresenter

/**
 *@trinh.binh on 24/04/2018
 *
 */
interface MainContract {
    interface View {
        fun showSavedToast()
    }

    interface Presenter : BasePresenter<View>{
        fun saveUser(user : User)
        fun getListUser() : Flowable<List<User>>
    }
}