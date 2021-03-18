package space.stroesku.duotektask.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import space.stroesku.duotektask.model.data.tables.Users

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: Users)
    @Query("SELECT * FROM users_data ORDER BY id ASC")
    fun readAllData(): LiveData<List<Users>>
}