package windy.dagger2unittest.ui.vm

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 *@trinh.binh on 15/11/2019
 */
class XUserViewModel: ViewModel{
    private var vl : Int
    @Inject
    constructor(a: Int){
        vl = a
    }
    fun getNumber(): Int{
        return vl
    }
}