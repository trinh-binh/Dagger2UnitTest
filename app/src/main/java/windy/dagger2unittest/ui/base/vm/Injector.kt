package windy.dagger2unittest.ui.base.vm
import windy.dagger2unittest.data.DataManager

/**
 *@trinh.binh on 13/10/2018
 */
interface Injector{
    fun inject(dataManager: DataManager)
}