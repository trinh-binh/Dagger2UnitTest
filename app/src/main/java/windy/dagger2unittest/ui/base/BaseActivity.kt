package windy.dagger2unittest.ui.base
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * @trinh.binh on 17/01/2018
 */
open abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    var composite : CompositeDisposable = CompositeDisposable()

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

    abstract fun inject()

    override fun onDestroy() {
        composite.dispose()
        super.onDestroy()
    }
}
