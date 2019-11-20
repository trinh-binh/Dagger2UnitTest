package windy.dagger2unittest.data.remote.http.response

import com.google.gson.annotations.SerializedName

/**
 *@trinh.binh on 07/03/2018
 *
 */
open class BaseResponse<T>{
    @SerializedName("code") var code : Int = 0
    @SerializedName("message") var message : String = "message"
    @SerializedName("result")  var result : T? = null

}