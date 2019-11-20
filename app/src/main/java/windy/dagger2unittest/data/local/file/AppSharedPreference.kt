package windy.dagger2unittest.data.local.file

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

/**
 * @trinh.binh on 27/02/2018
 */
class AppSharedPreference : FileService{
    private var sharedPreferences : SharedPreferences
    constructor(context: Context){
        sharedPreferences = context.getSharedPreferences("shared_preference", Context.MODE_PRIVATE)
    }

    override fun addString(key : String , value: String){
        Log.d("windy.f","add string to shared preference: $key -> $value")
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String, default : String) : String {
        return sharedPreferences.getString(key, default)
    }

}
