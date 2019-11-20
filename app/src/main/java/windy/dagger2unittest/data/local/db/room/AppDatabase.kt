package windy.dagger2unittest.data.local.db.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * @trinh.binh on 19/07/2018
 */
@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getUserDao(): UserDao
    companion object{
        private const val DB_NAME = "base_db"
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,
                DB_NAME
            )
                .fallbackToDestructiveMigration() // update version -->clear all data-> no migrate
                .build()
/*            if(INSTANCE == null){
                synchronized(AppDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration() // update version -->clear all data-> no migrate
                        .build()
                }
            }
            return INSTANCE*/
        }
    }

}