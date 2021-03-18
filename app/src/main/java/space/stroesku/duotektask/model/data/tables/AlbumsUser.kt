package space.stroesku.duotektask.model.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "albums_data")
data class AlbumsUser(
    @PrimaryKey val userId: Int,
    @ColumnInfo val id: Int,
    @ColumnInfo val title: String
)