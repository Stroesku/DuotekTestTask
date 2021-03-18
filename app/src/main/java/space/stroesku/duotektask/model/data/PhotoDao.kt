package space.stroesku.duotektask.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import space.stroesku.duotektask.model.data.tables.AlbumsUser
import space.stroesku.duotektask.model.data.tables.PhotosAlbum


@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPhoto(photo: PhotosAlbum)
    @Query("SELECT * FROM photos_data ORDER BY 'photos_data' ASC")
    fun readAllData(): LiveData<List<AlbumsUser>>
}