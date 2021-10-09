package com.myself.kotlinplayer.base

import com.alibaba.fastjson.JSON
import com.myself.kotlinplayer.net.NetManager
import com.myself.kotlinplayer.net.ResponseHandler
import okhttp3.FormBody
import java.lang.reflect.ParameterizedType

/**
 * @Created by Jams
 * @Created time 2021/10/8 11:01
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 11:01
 * @dese todo
 */
open class BaseRequest<RESPONSE>(open val url: String, open val formBody: FormBody, open val handler: ResponseHandler<RESPONSE>) {

    fun parseResponse(response: String): RESPONSE {
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return JSON.parseObject(response, type)
    }

    fun execute(){
        NetManager.manager.fetchDatas(this)
    }
}