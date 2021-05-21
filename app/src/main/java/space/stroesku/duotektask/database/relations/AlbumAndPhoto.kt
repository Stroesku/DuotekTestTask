package space.stroesku.duotektask.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.Photo

data class AlbumAndPhoto(
    @Embedded val album: Album,
    @Relation(
        parentColumn = "id",
        entityColumn = "albumId"
    )
    val photos: List<Photo>
)
