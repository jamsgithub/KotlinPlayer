package com.myself.kotlinplayer.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * @Created by Jams
 * @Created time 2021/10/11 11:43
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/11 11:43
 * @dese todo
 */
class SharedPreferencesUtils(var context: Context) {
    //    private var editor : SharedPreferences.Editor? = null
    //    private var sp:SharedPreferences? = null
    val sp by lazy { context.getSharedPreferences("info", MODE_PRIVATE) }
    val editor by lazy { sp.edit() }


    fun putString(key: String, value: String) {
        val edit = editor
        editor?.let {
            it.putString(key, value)
            it.commit()
        }
    }

    fun getString(key: String): String? {
        return sp?.getString(key, "")
    }
}