package windy.dagger2unittest.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import dagger.android.support.AndroidSupportInjection
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.fragment_main.*
import windy.dagger2unittest.R
import windy.dagger2unittest.app.App
import windy.dagger2unittest.di.module.MainModule
import windy.dagger2unittest.ui.base.BaseFragment
import windy.dagger2unittest.ui.main.adapter.ItemActionListener
import windy.dagger2unittest.ui.main.adapter.UserAdapter
import javax.inject.Inject

/**
 *@trinh.binh on 21/01/2018
 *
 */
class MainFragment : BaseFragment(), MainContract.View{

    @Inject
    lateinit var mainPresenter: MainContract.Presenter
    private lateinit var userAdapter : UserAdapter

    companion object {
        fun createInstance(tag : String) : MainFragment{
            var fragment = MainFragment()
            var bundle = Bundle()
            bundle.putString("tag", tag)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userAdapter = UserAdapter(activity!!.baseContext)
        mainPresenter.attachView(this)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retainInstance = true
        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        userAdapter.itemActionListener = object : ItemActionListener {
            override fun onClick(pos: Int) {
                mainPresenter.saveUser(userAdapter.list[pos])
            }
        }
        recycler_view.adapter = userAdapter
        doSubscribe(mainPresenter.getListUser(), Consumer {
            userAdapter.updateList(it)
        }, Consumer {
            Log.d("windy.f","Something wrong")
        })
    }

    override fun showSavedToast() {
        Log.d("windy.f","show toast")
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }

    override fun inject(){
        AndroidSupportInjection.inject(this)
//        App.getInstance().appComponent
//            .createMainComponent(MainModule())
//            .inject(this)
    }

}