package space.stroesku.duotektask.model.data

data class Root(
    val id:Int = 0,
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val address: Address = Address("","","","",Geo("","")),
    val phone: String = "",
    val website: String = "",
    val company: Company = Company("","","")
)