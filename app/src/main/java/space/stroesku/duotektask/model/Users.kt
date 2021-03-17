package space.stroesku.duotektask.model


data class Users (
        val id: Int,
        val name: String,
        val username: String,
        val email: String,
        val phone: String,
        val website: String,

            val street: String,
            val suite: String,
            val city: String,
            val zipcode: String,
                val lat: String,
                val lng: String,

            val compName: String,
            val catchPhrase: String,
            val bs: String
)