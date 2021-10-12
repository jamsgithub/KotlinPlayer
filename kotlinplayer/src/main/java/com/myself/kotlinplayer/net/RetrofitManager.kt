package com.myself.kotlinplayer.net

import android.content.Context
import com.myself.kotlinplayer.AUTHORIZATION
import com.myself.kotlinplayer.net.convert.FastJsonConverterFactory
import com.myself.kotlinplayer.utils.SharedPreferencesUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory

/**
 * @Created by Jams
 * @Created time 2021/10/11 11:01
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/11 11:01
 * @dese todo
 */
class RetrofitManager private constructor(){
    private val BASE_URL = "http://192.168.1.51:8200"
    companion object{
        val manager by lazy { RetrofitManager() }
    }

    fun create(baseUrl: String?,context: Context): Retrofit{
        var url = baseUrl
        if (url == null || url == ""){
            url = BASE_URL
        }

        var client = OkHttpClient()
        val builder = client.newBuilder();
        client = builder.addNetworkInterceptor(object : Interceptor{
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()
                SharedPreferencesUtils(context).getString(AUTHORIZATION)?.let {
                    request = request.newBuilder()
                        .addHeader("Authorization", it)
                        .build()
                }
                return chain.proceed(request)
            }

        }).build()


        return Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(FastJsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

}