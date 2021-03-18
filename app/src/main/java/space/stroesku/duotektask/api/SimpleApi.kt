package space.stroesku.duotektask.api


import retrofit2.Response
import retrofit2.http.GET
import space.stroesku.duotektask.model.data.Root
import space.stroesku.duotektask.model.data.tables.Users

interface SimpleApi {
    @GET("/users")
    suspend fun getUsers(): Response<List<Root>>
}
