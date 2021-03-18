package space.stroesku.duotektask.model.data.albums.photos


import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Photo(
    @PrimaryKey
    val albumId: Int = 0,
    val id: Int = 0,
    val thumbnailUrl: String = "",
    val title: String = "",
    val url: String = ""
)