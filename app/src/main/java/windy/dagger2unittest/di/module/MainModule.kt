package windy.dagger2unittest.di.module

import dagger.Module
import dagger.Provides
import windy.dagger2unittest.ui.main.MainContract
import windy.dagger2unittest.ui.main.MainPresenter

/**
 * @trinh.binh on 19/01/2018
 */
@Module
class MainModule {

    @Provides
    fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter{
        return presenter
    }
}