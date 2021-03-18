package space.stroesku.duotektask.model.data.repo


import retrofit2.Response
import space.stroesku.duotektask.api.RetrofitInstance
import space.stroesku.duotektask.model.data.tables.Users
import javax.inject.Singleton


@Singleton
class Repository {
//???????????????????????????????????
    val readAllData:  Response<List<Users>>

 suspend fun getUsers(): Response<List<Users>>{
    return RetrofitInstance.api.getUsers()
 }
//???????????????????????????????????

}















//    fun getList(){
//
//        AndroidNetworking.get("http://jsonplaceholder.typicode.com/users")
//            .build()
//            .getAsObject(UserData::class.java, object:ParsedRequestListener<space.stroesku.duotektask.model.UserData>{
//                override fun onResponse(response: space.stroesku.duotektask.model.UserData?) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onError(anError: ANError?) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//    }