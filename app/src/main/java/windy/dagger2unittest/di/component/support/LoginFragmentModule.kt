package windy.dagger2unittest.di.component.support

import dagger.Module
import dagger.android.ContributesAndroidInjector
import windy.dagger2unittest.ui.login.login.LoginFragment
import windy.dagger2unittest.ui.login.resetpwd.ResetPasswordFragment

/**
 *@trinh.binh on 22/10/2019
 */
@Module
abstract class LoginFragmentModule {
    @ContributesAndroidInjector
    abstract fun injectLoginFragment(): LoginFragment
    @ContributesAndroidInjector
    abstract fun injectResetFragment(): ResetPasswordFragment
}