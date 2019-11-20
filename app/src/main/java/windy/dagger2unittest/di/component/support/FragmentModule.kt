package windy.dagger2unittest.di.component.support

import dagger.Module
import dagger.android.ContributesAndroidInjector
import windy.dagger2unittest.di.module.MainModule
import windy.dagger2unittest.ui.main.MainFragment

/**
 * @trinh.binh on 18/10/2019
 */
@Module
abstract class FragmentModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun injectMainFragment(): MainFragment

}
