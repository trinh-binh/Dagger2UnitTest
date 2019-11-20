package windy.dagger2unittest.ui.base
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * @trinh.binh on 21/01/2018
 */
open abstract class BaseFragment : Fragment() {
    private var composite : CompositeDisposable = CompositeDisposable()

    override fun onAttach(context: Context?) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), container, false)
    }

    abstract fun getLayoutRes() : Int
    abstract fun inject()

    fun <T> doSubscribe(flowable: Flowable<T>, consumer: Consumer<T>, error : Consumer<Throwable>){
        var disposable = flowable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(consumer, error)
        composite.add(disposable)
    }

    fun <T> doSubscribe(flowable: Flowable<T>, subscriber: DisposableSubscriber<T>){
        var disposable = flowable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(subscriber)
        composite.add(disposable)
    }

    override fun onDestroy() {
        composite.dispose()
        super.onDestroy()
    }
}
