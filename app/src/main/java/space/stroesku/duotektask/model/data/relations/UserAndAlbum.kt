package space.stroesku.duotektask.model.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.users.User

data class UserAndAlbum (
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "albumId"
    )
    val album: Album
)


