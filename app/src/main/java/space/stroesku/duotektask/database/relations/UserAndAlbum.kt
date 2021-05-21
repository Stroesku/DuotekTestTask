package space.stroesku.duotektask.database.relations

import androidx.room.Embedded
import androidx.room.Relation
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.User

data class UserAndAlbum (
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val albums: List<Album>
)


