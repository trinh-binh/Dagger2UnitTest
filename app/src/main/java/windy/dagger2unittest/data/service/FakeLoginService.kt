package windy.dagger2unittest.data.service

/**
 * @trinh.binh on 16/10/2018
 */
class FakeLoginService : LoginService {
    override fun login(userName: String, pwd: String): Boolean {
        return false
    }

    override fun resetPwd(userName: String, email: String): Boolean {
        return true
    }

    override fun getUserName(): String {
        return "Duc Binh"
    }
}
