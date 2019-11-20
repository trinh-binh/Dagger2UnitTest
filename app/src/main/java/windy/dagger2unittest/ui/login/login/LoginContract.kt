package windy.dagger2unittest.ui.login.login

import windy.dagger2unittest.ui.base.BasePresenter

/**
 * @trinh.binh on 10/10/2018
 */
interface LoginContract {
    interface View {
        fun showResetPwdScreen(code: Int)
        fun goToMain()
    }

    interface Presenter : BasePresenter<View>{
        fun login(userName: String, pwd: String)
    }
}