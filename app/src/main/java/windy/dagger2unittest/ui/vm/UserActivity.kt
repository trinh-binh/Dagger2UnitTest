package windy.dagger2unittest.ui.vm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import windy.dagger2unittest.R
import windy.dagger2unittest.ui.base.BaseActivity
import windy.dagger2unittest.ui.base.vm.AppVMProviderFactory
import javax.inject.Inject

/**
 *@trinh.binh on 13/10/2018
 */
class UserActivity : BaseActivity() {
/*    private lateinit var viewModel: UserViewModel
    @Inject
    lateinit var viewModelFactory: AppViewModelProviderFactory
    private val viewModel: UserViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
    }*/
    private lateinit var viewModel: GodUserViewModel
    private lateinit var xVM: XUserViewModel
    @Inject
    lateinit var viewModelFactory: AppVMProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_layout)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(GodUserViewModel::class.java)
        xVM = ViewModelProviders.of(this, viewModelFactory).get(XUserViewModel::class.java)
        composite.add(viewModel.getListUser()
            .subscribe {
                Log.d("windy.f", "god " + it.size)
            })
        Log.d("windy.f", "xxx " + xVM.getNumber())
    }

    override fun inject() {
        AndroidInjection.inject(this)
    }

}