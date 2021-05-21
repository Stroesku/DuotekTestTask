package space.stroesku.duotektask.model.data.repo


import android.util.Log
import space.stroesku.duotektask.api.RetrofitInstance
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo
import space.stroesku.duotektask.model.data.users.User
import javax.inject.Singleton


@Singleton
class Repository {

    //val readAllData:  Response<List<Users>>

    suspend fun getUsers(): List<User> {
        val response = RetrofitInstance.api.getUsers()
        return if (response.isSuccessful) {
            Log.e("STROESKU", "users:${response.body()?.size.toString()}")
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }


    suspend fun getAlbums(): List<Album> {
        val response = RetrofitInstance.api.getAlbums()
        return if (response.isSuccessful) {
            Log.e("STROESKU", "albums:${response.body()?.size.toString()}")
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }
    suspend fun getPhotos(): List<Photo> {
        val response = RetrofitInstance.api.getPhotos()
        return if (response.isSuccessful) {
            Log.e("STROESKU", "photos:${response.body()?.size.toString()}")
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }

}
