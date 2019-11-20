package windy.dagger2unittest.data.service

/**
 * @trinh.binh on 15/10/2018
 */
interface LoginService {

    fun login(userName: String, pwd: String): Boolean

    fun resetPwd(userName: String, email: String) : Boolean

    fun getUserName(): String

}
