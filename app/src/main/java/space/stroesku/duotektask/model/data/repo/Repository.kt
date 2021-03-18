package space.stroesku.duotektask.model.data.repo


import android.util.Log
import space.stroesku.duotektask.api.RetrofitInstance
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.users.User
import javax.inject.Singleton


@Singleton
class Repository {
//???????????????????????????????????
    //val readAllData:  Response<List<Users>>

    suspend fun getUsers(): List<User> {
        val response = RetrofitInstance.api.getUsers()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }

    suspend fun getAlbums(): List<Album> {
        val response = RetrofitInstance.api.getAlbums()
        val result = if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
        return result
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
