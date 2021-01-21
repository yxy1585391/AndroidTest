package com.example.retrofittest

import okhttp3.CacheControl
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>

    @GET("{page}/get_data.json")
    fun getData(@Path("page") page: Int): Call<List<App>>

    @GET("get_data.json")
    fun getData(@Query("u") user: String, @Query("t") token: String): Call<List<App>>

    @DELETE("data/{id}")
    fun deleteData(@Path("id") id: String): Call<ResponseBody>

    @POST("data/create")
    fun createData(@Body data: Data): Call<ResponseBody>

//    静态header声明
    @Headers("User_Agent: okhttp","Cache-Control: max-age=0")
    @GET("get_data.json")
    fun getData(): Call<Data>

    //动态header声明
    @GET("get_data.json")
    fun getData1(@Header("User-Agent") userAgent: String, @Header("Cache-Control") cacheControl: String): Call<Data>
 }