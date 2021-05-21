package space.stroesku.duotektask.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(foreignKeys = [ForeignKey( entity = User::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("userId"),
    onDelete = ForeignKey.CASCADE)]
)

data class Album(
    @PrimaryKey val id: Int = 0,
    val userId: Int = 0,
    val title: String = ""
) : Serializable
