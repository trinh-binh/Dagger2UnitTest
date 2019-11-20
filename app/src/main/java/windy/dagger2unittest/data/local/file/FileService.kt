package windy.dagger2unittest.data.local.file

/**
 * @trinh.binh on 22/07/2018
 */
interface FileService{
    fun addString(key : String , value: String)
    fun getString(key: String, default : String) : String
}