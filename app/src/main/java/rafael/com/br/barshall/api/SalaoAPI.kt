package rafael.com.br.barshall.api

import rafael.com.br.barshall.model.StatusAPI
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.*

interface SalaoAPI{

    @GET("/check/checkOn")
    fun checkOn(): Call<StatusAPI>
}