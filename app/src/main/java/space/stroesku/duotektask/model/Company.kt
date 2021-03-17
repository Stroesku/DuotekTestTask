package space.stroesku.duotektask.model


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("name")
    val name: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("bs")
    val bs: String
)