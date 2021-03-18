package space.stroesku.duotektask.model.data.users


import com.google.gson.annotations.SerializedName
import space.stroesku.duotektask.model.data.users.Geo

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String,
    @SerializedName("geo")
    val geo: Geo
)