package windy.dagger2unittest.ui.login.resetpwd

import windy.dagger2unittest.data.service.LoginService
import javax.inject.Inject
import javax.inject.Named

/**
 * @trinh.binh on 15/08/2018
 */
class ResetPasswordPresenter : PasswordContract.Presenter {
    private var view : PasswordContract.View? = null

    @Inject
    @field:Named("login_service")
    lateinit var loginService: LoginService

    @Inject
    constructor(){
        //loginService = LoginServiceImp()
    }

    override fun resetPwd(name: String, email : String) {
        if(loginService.resetPwd(name, email)){
            view?.onResetDone()
        }
    }

    override fun getUserName(): String {
        return loginService.getUserName()
    }

    override fun attachView(v: PasswordContract.View) {
        view = v
    }

    override fun dropView() {
        view = null
    }

}