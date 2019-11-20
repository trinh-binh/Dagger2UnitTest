package windy.dagger2unittest.di.component

import dagger.Component
import windy.dagger2unittest.di.module.LoginModule
import windy.dagger2unittest.di.scope.LoginScope
import windy.dagger2unittest.ui.login.login.LoginFragment
import windy.dagger2unittest.ui.login.resetpwd.ResetPasswordFragment

/**
 * @trinh.binh on 14/07/2018
 */
@LoginScope
@Component(dependencies = [AppComponent::class], modules = [LoginModule::class])
interface LoginComponent{
    fun inject(loginFragment: LoginFragment)
    fun inject(passwordFragment: ResetPasswordFragment)
}