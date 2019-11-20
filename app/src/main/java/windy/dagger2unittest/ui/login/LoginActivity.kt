package windy.dagger2unittest.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import windy.dagger2unittest.R
import windy.dagger2unittest.ui.base.BaseActivity
import windy.dagger2unittest.ui.login.login.LoginFragment
import windy.dagger2unittest.ui.login.resetpwd.ResetPasswordFragment
import windy.dagger2unittest.ui.main.MainActivity
import javax.inject.Inject

/**
 * @trinh.binh on 22/07/2018
 */
class LoginActivity : BaseActivity(), LoginNavigator, HasSupportFragmentInjector {

    private lateinit var loginFragment: LoginFragment
    private lateinit var resetPasswordFragment: ResetPasswordFragment
    private lateinit var transaction: FragmentTransaction
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val register = supportFragmentManager.findFragmentByTag("reset_pwd")
        resetPasswordFragment = if (register != null) register as ResetPasswordFragment
        else ResetPasswordFragment()
        val login = supportFragmentManager.findFragmentByTag("login")
        loginFragment = if (login != null) login as LoginFragment
        else LoginFragment()

        loginFragment.navigator = this
        resetPasswordFragment.navigator = this

        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, loginFragment, "login")
        transaction.commit()
    }

    override fun navigateToResetPwd() {
        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, resetPasswordFragment, "reset_pwd")
        transaction.commit()
    }

    override fun navigateToLogin() {
        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, loginFragment, "login")
        transaction.commit()
    }

    override fun goiToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun inject() {
        //App.getInstance().createLoginComponent()
        AndroidInjection.inject(this)
    }
}