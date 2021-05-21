package space.stroesku.duotektask.model.data.users

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class User(
    @PrimaryKey
    val id:Int = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    @Embedded(prefix = "user_")
    val address: Address = Address("","","","", Geo("","")),
    val phone: String = "",
    val website: String = "",
    @Embedded(prefix ="user_")
    val company: Company = Company("","","")
): Serializable

data class Address(
    val city: String,
    val street: String,
    val suite: String,
    val zipcode: String,
    @Embedded(prefix = "address_")
    val geo: Geo
): Serializable

data class Geo(
    val lat: String,
    val lng: String
): Serializable

data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
): Serializable

