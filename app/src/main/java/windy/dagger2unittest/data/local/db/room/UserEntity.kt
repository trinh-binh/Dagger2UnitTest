package windy.dagger2unittest.data.local.db.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @trinh.binh on 19/07/2018
 */
@Entity(tableName = "user")
class UserEntity{
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var id : Int = 0
    @ColumnInfo(name = "name") var name : String = ""
}