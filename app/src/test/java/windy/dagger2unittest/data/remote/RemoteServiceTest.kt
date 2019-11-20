package windy.dagger2unittest.data.remote

import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.data.remote.http.ApiService

/**
 * @trinh.binh on 16/10/2019
 */
class RemoteServiceTest {

    @InjectMocks
    lateinit var appRemoteService: AppRemoteService

    @Mock
    lateinit var apiService: ApiService

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getListUser(){
        val list =  ArrayList<User>()
        list.add(User(1, "AAA"))
        list.add(User(2, "BBB"))
        Mockito.`when`(apiService.getListUser()).thenReturn(Flowable.fromCallable { list })
        var results = ArrayList<String>()
        results.add("Binh")
        results.add("BBB")
        val observer = appRemoteService.getListUser()
            .map {
                val li = ArrayList<String>()
                for(u in it) {
                    li.add(u.name)
                }
                System.out.printf("size "+li.size)
                li
            }.test()
        observer.assertValues(results)
        observer.dispose()
    }

}