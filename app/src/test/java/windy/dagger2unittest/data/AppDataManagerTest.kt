package windy.dagger2unittest.data

import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Flowable
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.*
import windy.dagger2unittest.data.local.db.DBService
import windy.dagger2unittest.data.local.file.FileService
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.data.remote.RemoteService

/**
 * @trinh.binh on 16/10/2019
 */
class AppDataManagerTest{

    @InjectMocks
    lateinit var dataManager: AppDataManager
    @Mock
    lateinit var fileService: FileService
    @Mock
    lateinit var dbService: DBService
    @Mock
    lateinit var remoteService: RemoteService

    @Captor
    private lateinit var userCaptor : ArgumentCaptor<User>

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getListUser(){
        val list =  ArrayList<User>()
        list.add(User(1, "AAA"))
        list.add(User(2, "BBB"))
        Mockito.`when`(remoteService.getListUser()).thenReturn(Flowable.fromCallable { list })
        dataManager.getListUser().test()
        verify(fileService).addString("user_name", "AAA")

    }

    @Test
    fun saveUser(){
        val user = User(3,"Binh")
        dataManager.saveUser(user)
        Mockito.verify(dbService).saveUser(com.nhaarman.mockitokotlin2.capture(userCaptor))
        Assert.assertThat(userCaptor.value.name, CoreMatchers.`is`("Binh"))
    }
}