package space.stroesku.duotektask.model.data.albums

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Album(
    @PrimaryKey
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = ""
)
