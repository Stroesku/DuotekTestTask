package space.stroesku.duotektask.model.albums


import com.google.gson.annotations.SerializedName

data class AlbumDataItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int
)