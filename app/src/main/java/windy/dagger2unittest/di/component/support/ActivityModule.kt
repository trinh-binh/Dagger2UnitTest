package windy.dagger2unittest.di.component.support
import windy.dagger2unittest.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import windy.dagger2unittest.di.module.LoginModule
import windy.dagger2unittest.di.scope.LoginScope
import windy.dagger2unittest.ui.login.LoginActivity
import windy.dagger2unittest.ui.vm.UserActivity

/**
 *@trinh.binh on 18/10/2019
 */
@Module
abstract class ActivityModule {
    @LoginScope
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class, LoginModule::class])
    abstract fun injectLoginActivity(): LoginActivity
    @ContributesAndroidInjector
    abstract fun injectMainActivity(): MainActivity
    @ContributesAndroidInjector
    abstract fun injectUseractivity(): UserActivity
}