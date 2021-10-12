package com.myself.kotlinplayer.serviceInterface

import com.myself.kotlinplayer.model.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @Created by Jams
 * @Created time 2021/10/11 11:02
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/11 11:02
 * @dese todo
 */
interface ServiceInterface {
    @POST("/auth/jwt/token")
    fun login(@Body body : Map<String, String>): Call<BaseModel<String>>

    @GET("/auth/jwt/info")
    fun getUserInfo(): Call<BaseModel<UserInfoBean>>
}