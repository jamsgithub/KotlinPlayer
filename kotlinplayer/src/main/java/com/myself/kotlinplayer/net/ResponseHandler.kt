package com.myself.kotlinplayer.net

/**
 * @Created by Jams
 * @Created time 2021/10/8 11:02
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 11:02
 * @dese todo
 */
interface ResponseHandler<RESPONSE> {
    fun onError(message:String?)
    fun onSuccess(response: RESPONSE?)
}