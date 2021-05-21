package space.stroesku.duotektask.model


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(foreignKeys = [ForeignKey( entity = Album::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("albumId"),
    onDelete = ForeignKey.CASCADE)]
)

data class Photo(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val albumId: Int = 0,
    val thumbnailUrl: String = "",
    val title: String = "",
    val url: String = ""
)