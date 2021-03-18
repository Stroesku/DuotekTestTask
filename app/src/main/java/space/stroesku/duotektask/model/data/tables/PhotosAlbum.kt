package space.stroesku.duotektask.model.data.tables


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_data")
data class PhotosAlbum(
    @PrimaryKey val id: Int,
    @ColumnInfo val albumId: Int,
    @ColumnInfo val thumbnailUrl: String,
    @ColumnInfo val title: String,
    @ColumnInfo val url: String,
    @ColumnInfo val photos: ArrayList<PhotosAlbum>
)