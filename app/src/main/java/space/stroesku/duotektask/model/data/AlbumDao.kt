package space.stroesku.duotektask.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import space.stroesku.duotektask.model.data.tables.AlbumsUser


@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAlbum(album: AlbumsUser)
    @Query("SELECT * FROM albums_data ORDER BY userId ASC")
    fun readAllData(): LiveData<List<AlbumsUser>>
}