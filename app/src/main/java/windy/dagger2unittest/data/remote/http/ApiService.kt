package windy.dagger2unittest.data.remote.http

import io.reactivex.Flowable
import retrofit2.http.GET
import windy.dagger2unittest.data.model.User


/**
 *@trinh.binh on 07/03/2018
 *
 */
interface ApiService {

    @GET("user")
    fun getListUser(): Flowable<List<User>>

/*    //application
    @POST("login")
    fun login(@Body body: Map<String, Object>): Flowable<LoginResponse>

    @GET("getSome")
    fun getSomeThing(@Header("Authorization") token: String, @Query("index") index: String): Flowable<Boolean>

    @POST("postSome")
    fun postSomeThing(@HeaderMap header: Map<String, String>, @Body body: Map<String, String>): Flowable<Boolean>

    @GET("group/{id}/users")
    fun groupList(@Path("id") groupId: Int, @QueryMap options: Map<String, String>): Flowable<List<User>>

    @FormUrlEncoded
    @POST("user/edit")
    fun updateUser(@Field("first_name") first: String, @Field("last_name") last: String): Flowable<User>

    @Multipart
    @POST("upload")
    fun uploadFile(
        @Part("description") description: RequestBody,
        @Part file: MultipartBody.Part
    ): Flowable<ResponseBody>


        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        file = new File("/storage/emulated/0/Pictures/MyApp/test.png");
        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_PNG, file);

    @GET("download")
    fun downloadFile(@Url url: String): Flowable<ResponseBody>
    // response.body().byteStream() */
}