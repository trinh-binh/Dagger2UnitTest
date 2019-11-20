package windy.dagger2unittest.data.remote

import io.reactivex.Flowable
import windy.dagger2unittest.data.model.User
import windy.dagger2unittest.data.remote.http.ApiService
import windy.dagger2unittest.di.scope.AppScope
import javax.inject.Inject
import javax.inject.Named

/**
 * @trinh.binh on 19/07/2018
 */
@AppScope
class AppRemoteService : RemoteService {
    @field:Named("fake_api_service")
    @Inject
    lateinit var apiService: ApiService

    @Inject
    constructor() {

    }

    override fun getListUser(): Flowable<List<User>> {
        return apiService.getListUser()
            .map {
                var list = ArrayList<User>()
                for (i in 0 until it.size) {
                    if (i % 2 == 0) list.add(User(it[i].id, "Binh"))
                    else list.add(it[i])
                }
                list
            }
    }

}