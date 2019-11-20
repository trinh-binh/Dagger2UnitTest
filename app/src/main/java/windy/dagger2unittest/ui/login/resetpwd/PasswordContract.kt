package windy.dagger2unittest.ui.login.resetpwd

import windy.dagger2unittest.ui.base.BasePresenter

/**
 * @trinh.binh on 15/09/2018
 */
interface PasswordContract {
    interface View {
        fun onResetDone()
    }

    interface Presenter : BasePresenter<View> {
        fun resetPwd(name: String, email: String)
        fun getUserName(): String
    }
}