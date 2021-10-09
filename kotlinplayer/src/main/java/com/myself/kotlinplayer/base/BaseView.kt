package com.myself.kotlinplayer.base

import com.myself.kotlinplayer.model.HomeItemBean

/**
 * @Created by Jams
 * @Created time 2021/10/8 15:01
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 15:01
 * @dese todo
 */
interface BaseView<RESPONSE> {
    fun onError(msg: String?)
    fun onResponse(response: RESPONSE, curPage: Int)
}