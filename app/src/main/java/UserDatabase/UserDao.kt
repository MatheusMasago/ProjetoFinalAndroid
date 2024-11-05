package UserDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM UserEntity")
    fun getAll(): List<UserEntity>

    @Insert
    fun insertAll(vararg user: List<UserEntity>)

    @Insert
    fun insert(user: List<UserEntity>)

    @Delete
    fun delete(user: UserEntity)
}