package com.example.pad.services

import com.example.pad.entity.UserInfo
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


/**
 * @Created by Jams
 * @Created time 2021/9/10 17:25
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/10 17:25
 * @dese todo
 */
interface CommonApiService {

    @FormUrlEncoded
    @POST("/login")
    open fun login(
        @Field("userName") userName: String,
        @Field("password") password: String
    ): Call<UserInfo>

}