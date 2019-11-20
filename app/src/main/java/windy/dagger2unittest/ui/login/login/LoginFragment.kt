package windy.dagger2unittest.ui.login.login

import android.os.Bundle
import android.view.View
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_login.*
import windy.dagger2unittest.R
import windy.dagger2unittest.ui.base.BaseFragment
import windy.dagger2unittest.ui.login.LoginNavigator
import javax.inject.Inject

/**
 * @trinh.binh on 10/10/2018
 */
class LoginFragment : BaseFragment(), LoginContract.View{

    @Inject
    lateinit var loginPresenter: LoginContract.Presenter
    var navigator: LoginNavigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        //loginPresenter = LoginPresenter()
        loginPresenter.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_login.setOnClickListener {
            loginPresenter.login(user_name.text.toString(),password.text.toString())
        }
    }

    override fun showResetPwdScreen(code: Int) {
        navigator?.navigateToResetPwd()
    }

    override fun goToMain() {
        navigator?.goiToMain()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_login
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.dropView()
    }


    override fun inject() {
//        val component = DaggerLoginComponent.builder()
//            .appComponent(App.getInstance().appComponent)
//            .loginModule(LoginModule())
//            .build()
//        App.getInstance().loginComponent.inject(this)
        AndroidSupportInjection.inject(this)
    }

}