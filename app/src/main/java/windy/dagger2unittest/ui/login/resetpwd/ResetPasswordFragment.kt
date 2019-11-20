package windy.dagger2unittest.ui.login.resetpwd

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_reset.*
import windy.dagger2unittest.R
import windy.dagger2unittest.ui.base.BaseFragment
import windy.dagger2unittest.ui.login.LoginNavigator
import javax.inject.Inject

/**
 * @trinh.binh on 10/08/2018
 */
class ResetPasswordFragment : BaseFragment(), PasswordContract.View{
    var navigator: LoginNavigator? = null

    @Inject
    lateinit var presenter: PasswordContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        presenter.attachView(this)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user_name.setText(presenter.getUserName())
        btn_reset.setOnClickListener {
            presenter.resetPwd(user_name.text.toString(), email.text.toString())
        }
    }

    override fun onResetDone() {
        navigator?.navigateToLogin()
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_reset
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }

    override fun inject() {
        //App.getInstance().loginComponent.inject(this)
        AndroidSupportInjection.inject(this)
    }



}