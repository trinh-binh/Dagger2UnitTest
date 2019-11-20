package windy.dagger2unittest.data.remote.http

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User

/**
 * @trinh.binh on 16/10/2019
 */
class FakeApiService : ApiService {
    override fun getListUser(): Flowable<List<User>> {
        var list = ArrayList<User>()
        list.add(User(1,"Binh"))
        list.add(User(2,"Windy"))
        return Flowable.fromCallable { list }
    }

}