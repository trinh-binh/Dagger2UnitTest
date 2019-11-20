package windy.dagger2unittest.data.remote.http.response

import com.google.gson.annotations.SerializedName

/**
 *@trinh.binh on 07/03/2018
 *
 */
class LoginResponse : BaseResponse<LoginResponse.Session>(){
    class Session{
        @SerializedName("session_id") var sessionId = "session_id"
        @SerializedName("session_expire_data") var sessionExpireData = "sessionExpireData"
    }
}