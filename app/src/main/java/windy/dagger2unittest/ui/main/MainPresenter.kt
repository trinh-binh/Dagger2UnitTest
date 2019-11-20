package windy.dagger2unittest.ui.main

import io.reactivex.Flowable
import windy.dagger2unittest.data.DataManager
import windy.dagger2unittest.data.model.User
import javax.inject.Inject

/**
 *@trinh.binh on 24/04/2018
 *
 */
class MainPresenter : MainContract.Presenter{

    private var view: MainContract.View? = null

    @Inject
    lateinit var dataManager : DataManager

    @Inject
    constructor()

    override fun saveUser(user: User) {
        dataManager.saveUser(user)
    }

    override fun getListUser(): Flowable<List<User>> {
        return dataManager.getListUser()
    }

    override fun attachView(v: MainContract.View) {
        view = v
    }

    override fun dropView() {
        view = null
    }

}