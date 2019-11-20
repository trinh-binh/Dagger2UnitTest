package windy.dagger2unittest.ui.base.vm

import android.arch.lifecycle.ViewModel
import windy.dagger2unittest.data.DataManager

/**
 *@trinh.binh on 13/10/2018
 */
open class BaseViewModel : ViewModel(), Injector{
    protected lateinit var dataManager: DataManager

    override fun inject(data: DataManager) {
        //println("come here")
        dataManager = data
    }

    override fun onCleared() {
        super.onCleared()
    }

}