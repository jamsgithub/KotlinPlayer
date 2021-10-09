package com.myself.kotlinplayer.utils

import android.os.Handler
import android.os.Looper

/**
 * @Created by Jams
 * @Created time 2021/10/7 15:20
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/7 15:20
 * @dese todo
 */
object ThreadUtil {
    private val handle = Handler(Looper.getMainLooper())

    fun runOnMainThread(runnable: Runnable){
        handle.post(runnable)
    }

}