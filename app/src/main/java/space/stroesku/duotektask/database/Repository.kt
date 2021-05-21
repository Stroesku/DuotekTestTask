package space.stroesku.duotektask.database


import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import space.stroesku.duotektask.api.RetrofitInstance
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.Photo
import space.stroesku.duotektask.model.User
import space.stroesku.duotektask.utils.App
import javax.inject.Singleton


@Singleton
class Repository {
    val database = DuotekDatabase.getInstance(App.appContext)
    val dao = database.dao

    fun searchUser(searchQuery: String): Flow<List<User>> {
        return dao.searchUser(searchQuery)
    }

    private suspend fun getUsers(): List<User> {
        val response = RetrofitInstance.api.getUsers()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }

    private suspend fun getAlbums(): List<Album> {
        val response = RetrofitInstance.api.getAlbums()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }

    private suspend fun getPhotos(): List<Photo> {
        val response = RetrofitInstance.api.getPhotos()
        return if (response.isSuccessful) {
            response.body() ?: emptyList()
        } else {
            emptyList()
        }
    }

     suspend fun getFromRemote() {
        dao.insertUser(getUsers())
        dao.insertAlbum(getAlbums())
        dao.insertPhoto(getPhotos())
    }
}
