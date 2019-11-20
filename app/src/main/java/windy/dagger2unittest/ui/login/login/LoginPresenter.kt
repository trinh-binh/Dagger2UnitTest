package windy.dagger2unittest.ui.login.login

import windy.dagger2unittest.data.service.LoginService
import javax.inject.Inject
import javax.inject.Named

/**
 * @trinh.binh on 10/10/2018
 */
class LoginPresenter : LoginContract.Presenter {
    private var view: LoginContract.View? = null

    @field:Named("login_service")
    @Inject
    lateinit var loginService: LoginService

    /**
     * 1. When LoginService need some objects to implementation.
     * -> need pass to constructor --> higher level class also change to prepare these object
     * (LoginService need ApiService to send https request)
     * 2. In case replace real LoginService with OtherService (MySQL -> MongoDB).
     *   Configs change, init changes --> higher level class also change
     */

    @Inject
    constructor()
//    @Inject
//    constructor(@Named("login_service") ls: LoginService){
//        loginService = ls
//    }

    override fun login(userName: String, pwd: String) {
        val lg = loginService.login(userName, pwd)
        if (lg) {
            view?.goToMain()
        } else {
            view?.showResetPwdScreen(1)
        }
    }

    override fun attachView(v: LoginContract.View) {
        view = v
    }

    override fun dropView() {
        view = null
    }

}