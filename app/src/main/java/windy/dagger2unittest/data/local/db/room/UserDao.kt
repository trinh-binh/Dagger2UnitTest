package windy.dagger2unittest.data.local.db.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

/**
 * @trinh.binh on 19/07/2018
 */
@Dao
interface UserDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user : UserEntity)
    @Query("DELETE FROM user")
    fun deleteAllUser()
    @Query("SELECT * FROM user LIMIT 10")
    fun getTop10User(): Flowable<List<UserEntity>>
}