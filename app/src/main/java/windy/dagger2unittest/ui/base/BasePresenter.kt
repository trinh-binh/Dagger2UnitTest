package windy.dagger2unittest.ui.base

/**
 *@trinh.binh on 18/01/2018
 *
 */
interface BasePresenter<V> {
    fun attachView(v : V)
    fun dropView()
}