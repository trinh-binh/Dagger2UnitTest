package windy.dagger2unittest.di.module

import dagger.Module
import dagger.Provides
import windy.dagger2unittest.data.service.FakeLoginService
import windy.dagger2unittest.data.service.LoginService
import windy.dagger2unittest.data.service.LoginServiceImp
import windy.dagger2unittest.di.scope.LoginScope
import windy.dagger2unittest.ui.login.login.LoginContract
import windy.dagger2unittest.ui.login.login.LoginPresenter
import windy.dagger2unittest.ui.login.resetpwd.PasswordContract
import windy.dagger2unittest.ui.login.resetpwd.ResetPasswordPresenter
import javax.inject.Named

/**
 * @trinh.binh on 10/02/2018
 */
@Module
class LoginModule {

    @Provides
    fun provideLoginPresenter(presenter: LoginPresenter) : LoginContract.Presenter{
        return presenter
    }

    @Provides
    fun providePwdPresenter(presenter: ResetPasswordPresenter) : PasswordContract.Presenter{
        return presenter
    }

    /**
     *  one login service instance in both LoginPresenter and ResetPasswordPresenter
     *  -> keep state in login activity scope
     */
    @Named("login_service")
    @Provides
    @LoginScope
    fun providerLoginService(): LoginService{
        return LoginServiceImp()
    }

    @Named("fake_login_service")
    @Provides
    fun providerFakeLoginService(): LoginService{
        return FakeLoginService()
    }

}