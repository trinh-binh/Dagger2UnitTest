package windy.dagger2unittest.ui.login.login

import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import windy.dagger2unittest.data.service.LoginService

/**
 * @trinh.binh on 15/10/2018
 */
class LoginPresenterTest {

    @InjectMocks
    private lateinit var loginPresenter : LoginPresenter

    @Mock
    private lateinit var view : LoginContract.View

    @Mock
    private lateinit var loginService: LoginService

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        loginPresenter.attachView(view)
    }

    @Test
    fun loginFailed(){
        Mockito.`when`(loginService.login(anyString(), anyString())).thenReturn(false)
        loginPresenter.login("aaa","abc")
        verify(view).showResetPwdScreen(1)
    }

    @Test
    fun loginSuccess(){
        Mockito.`when`(loginService.login(anyString(), anyString())).thenReturn(true)
        loginPresenter.login("aaa","kkk")
        verify(view, never()).showResetPwdScreen(1)
        verify(view).goToMain()
    }
}
