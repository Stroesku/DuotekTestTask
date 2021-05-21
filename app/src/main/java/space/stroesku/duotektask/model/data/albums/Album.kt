package space.stroesku.duotektask.model.data.albums

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Album (
    @PrimaryKey
    val userId: Int = 0,
    val id: Int = 0,
    val title: String = ""
): Serializable
