package windy.dagger2unittest.data.service

import android.util.Log
import windy.dagger2unittest.data.model.User

/**
 * @trinh.binh on 16/10/2018
 */
class LoginServiceImp : LoginService{
    private var user = User(1, "DefaultName")

    constructor(){
        Log.d("windy.f","Create new LoginService instance")
    }

    override fun login(userName: String, pwd: String): Boolean{
        user.name = userName
        if(pwd == "111") return true
        return false
    }

    override fun resetPwd(userName: String, email: String) : Boolean{
        user.name = userName
        Log.d("windy.f", "send new password to email $email")
        return true
    }

    override fun getUserName(): String {
        return user.name
    }
}