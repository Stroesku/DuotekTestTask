package space.stroesku.duotektask.model.data.repo


import android.util.Log
import space.stroesku.duotektask.api.RetrofitInstance
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.users.User
import javax.inject.Singleton


@Singleton
class Repository {

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


}
