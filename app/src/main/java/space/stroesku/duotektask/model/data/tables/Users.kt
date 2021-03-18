package space.stroesku.duotektask.model.data.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import space.stroesku.duotektask.model.data.Address
import space.stroesku.duotektask.model.data.Company

@Entity(tableName = "users_data")
data class Users (
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
    @ColumnInfo val phone: String,
    @ColumnInfo val website: String,
    @ColumnInfo val address: Address,
    @ColumnInfo val company: Company,
    @ColumnInfo val album: ArrayList<AlbumsUser>
)