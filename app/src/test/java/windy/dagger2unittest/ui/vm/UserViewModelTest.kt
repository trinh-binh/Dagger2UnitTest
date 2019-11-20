package windy.dagger2unittest.ui.vm
import android.support.v7.app.AppCompatActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import windy.dagger2unittest.data.DataManager

/**
 *@trinh.binh on 14/10/2018
 */
class UserViewModelTest{
    @InjectMocks
    lateinit var userViewModel: UserViewModel
    @Mock
    lateinit var dataManager: DataManager

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getNumber(){
        Mockito.`when`(dataManager.getNumber()).thenReturn(1)
        Assert.assertEquals(11, userViewModel.getNumber())
    }

    @Test
    fun getFail(){
        Mockito.`when`(dataManager.getNumber()).thenReturn(1)
        Assert.assertEquals(11, userViewModel.getNumber())
    }

}
