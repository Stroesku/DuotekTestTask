package space.stroesku.duotektask.api


import retrofit2.Response
import retrofit2.http.GET
import space.stroesku.duotektask.model.Users

interface SimpleApi {
    @GET("/users")
    suspend fun getUsers(): Response<List<Users>>
}