package UserDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database([UserEntity::class], version = 1)
abstract class UserDataBase: RoomDatabase(){
    abstract fun getUserDao():UserDao
}