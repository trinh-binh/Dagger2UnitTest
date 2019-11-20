package windy.dagger2unittest.ui.base.vm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import windy.dagger2unittest.di.scope.AppScope
import javax.inject.Inject
import javax.inject.Provider
/**
 *@trinh.binh on 14/10/2018
 */
@AppScope
class AppVMProviderFactory : ViewModelProvider.Factory {
    private var mapProvider : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

    @Inject
    constructor(map : Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>){
        mapProvider = map
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mapProvider[modelClass]?.get() as T
    }
}