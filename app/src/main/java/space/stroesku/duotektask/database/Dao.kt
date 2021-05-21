package space.stroesku.duotektask.database

import androidx.room.*
import androidx.room.Dao
import kotlinx.coroutines.flow.Flow
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.Photo
import space.stroesku.duotektask.model.User

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertUser(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAlbum(albums: List<Album>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertPhoto(photos: List<Photo>)


    @Transaction
    @Query("SELECT * FROM album WHERE userId = :userId")
    suspend fun getAlbumsOfUser(userId: Int): List<Album>

    @Transaction
    @Query("SELECT * FROM user")
    suspend fun getUsers(): List<User>

    @Transaction
    @Query("SELECT * FROM photo WHERE albumId = :albumId")
    suspend fun getPhotoOfAlbum(albumId: Int): List<Photo>

    @Transaction
    @Query("SELECT * FROM user WHERE name LIKE :searchQuery OR username LIKE :searchQuery")
    fun searchUser(searchQuery: String): Flow<List<User>>

}