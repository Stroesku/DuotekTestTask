package space.stroesku.duotektask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import space.stroesku.duotektask.utils.Constants.Companion.BASE_URL_USERS

object RetrofitInstance {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_USERS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}