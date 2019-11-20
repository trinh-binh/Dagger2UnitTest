package windy.dagger2unittest.app

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import windy.dagger2unittest.di.component.support.DaggerApplicationComponent
import javax.inject.Inject

/**
 *@trinh.binh on 16/01/2018
 *
 */
class App : Application(), HasActivityInjector, HasSupportFragmentInjector {

    //lateinit var appComponent: AppComponent
    //lateinit var loginComponent: LoginComponent
    @Inject
    lateinit var app: App

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun onCreate() {
        super.onCreate()
/*        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()*/
        DaggerApplicationComponent.builder()
            .applicationBind(this)
            .build()
            .inject(this)
    }


/*    fun createLoginComponent() : LoginComponent{
        loginComponent = DaggerLoginComponent.builder()
            .appComponent(appComponent)
            .loginModule(LoginModule())
            .build()
        return loginComponent
    }*/

}