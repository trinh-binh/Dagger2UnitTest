package windy.dagger2unittest.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.util.Log
import dagger.android.AndroidInjection
import windy.dagger2unittest.ui.base.BaseActivity
import windy.dagger2unittest.R
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private lateinit var transaction: FragmentTransaction
    private var mainFragment = MainFragment()
    @Inject
    lateinit var appCt: Context

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_place_holder, mainFragment, "tag")
        transaction.commit()
        Log.d("windy.f", "context $appCt")
    }

    override fun inject() {
        AndroidInjection.inject(this)
    }
}
