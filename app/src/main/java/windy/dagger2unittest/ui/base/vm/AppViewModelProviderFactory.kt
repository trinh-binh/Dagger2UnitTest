package windy.dagger2unittest.ui.base.vm
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import windy.dagger2unittest.data.DataManager
import windy.dagger2unittest.di.scope.AppScope
import javax.inject.Inject

/**
 *@trinh.binh on 13/10/2018
 */
@AppScope
class AppViewModelProviderFactory : ViewModelProvider.Factory{
    @Inject
    lateinit var dataManager: DataManager
    @Inject
    constructor()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val created : T = modelClass.newInstance()
        if(created is Injector) created.inject(dataManager)
        return created
    }

}