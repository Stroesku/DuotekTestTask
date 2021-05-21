package space.stroesku.duotektask.api


import retrofit2.Response
import retrofit2.http.GET
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo
import space.stroesku.duotektask.model.data.users.User

interface SimpleApi {
    @GET("/users")
    suspend fun getUsers(): Response<List<User>>

    @GET("/albums")
    suspend fun getAlbums(): Response<List<Album>>

    @GET("/photos")
    suspend fun getPhotos(): Response<List<Photo>>

}
