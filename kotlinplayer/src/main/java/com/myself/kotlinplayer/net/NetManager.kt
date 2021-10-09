package com.myself.kotlinplayer.net

import com.myself.kotlinplayer.base.BaseRequest
import com.myself.kotlinplayer.utils.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * @Created by Jams
 * @Created time 2021/10/8 11:05
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 11:05
 * @dese todo
 */
class NetManager private constructor(){
    val client by lazy { OkHttpClient() }
    companion object{
        val manager by lazy { NetManager() }
    }
    fun <RESPONSE> fetchDatas(baseRequest : BaseRequest<RESPONSE>){
        val request: Request = Request.Builder()
            .url(baseRequest.url)
            .post(baseRequest.formBody)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                val error = e
                val msg = e.message
                ThreadUtil.runOnMainThread(Runnable {
                    baseRequest.handler.onError(e.message)
                })
            }

            override fun onResponse(call: Call, response: Response) {
                val res = response
                val responseBody = response.body
                val body = response.body?.string()
                println("onResponse = $body")
                body?.let {
                    val parseResult = baseRequest.parseResponse(it)
                    ThreadUtil.runOnMainThread(Runnable {
                        baseRequest.handler.onSuccess(parseResult)
                    })
                }
            }

        })
    }
}