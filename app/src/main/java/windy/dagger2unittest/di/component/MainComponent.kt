package windy.dagger2unittest.di.component

import dagger.Subcomponent
import windy.dagger2unittest.di.module.MainModule
import windy.dagger2unittest.di.scope.MainScope
import windy.dagger2unittest.ui.main.MainFragment

/**
 * @trinh.binh on 17/10/2018
 */
@MainScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent{
    fun inject(mainFragment: MainFragment)
}