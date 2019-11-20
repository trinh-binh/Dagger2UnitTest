package windy.dagger2unittest.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import windy.dagger2unittest.ui.base.vm.AppVMProviderFactory
import windy.dagger2unittest.ui.vm.GodUserViewModel
import windy.dagger2unittest.ui.vm.XUserViewModel
import kotlin.reflect.KClass

/**
 *@trinh.binh on 15/11/2019
 */
@Module
abstract class ViewModelModule {
    /**
     * In case use multi-binding --> use @Binds instead of @Provides
     */
    @MustBeDocumented
    @Target(AnnotationTarget.FUNCTION)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Binds
    @IntoMap
    @ViewModelKey(GodUserViewModel::class)
    abstract fun bindGodUserViewModel(god: GodUserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(XUserViewModel::class)
    abstract fun bindXViewModel(xvm: XUserViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppVMProviderFactory): ViewModelProvider.Factory

}