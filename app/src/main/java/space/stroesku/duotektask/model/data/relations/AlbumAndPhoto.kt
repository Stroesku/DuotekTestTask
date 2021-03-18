package space.stroesku.duotektask.model.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo

data class AlbumAndPhoto(
    @Embedded val user: Album,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val photo: Photo
)
