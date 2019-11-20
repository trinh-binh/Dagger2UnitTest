package windy.dagger2unittest.di.component.support

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import windy.dagger2unittest.app.App
import windy.dagger2unittest.di.module.ViewModelModule
import windy.dagger2unittest.di.scope.AppScope

/**
 * @trinh.binh on 18/10/2019
 */
@AppScope
@Component(modules = [ApplicationModule::class, ViewModelModule::class, AndroidInjectionModule::class,  ActivityModule::class, FragmentModule::class])
interface ApplicationComponent {
    fun inject(application: App)
    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        @BindsInstance
        fun applicationBind(application: App): Builder

    }
}