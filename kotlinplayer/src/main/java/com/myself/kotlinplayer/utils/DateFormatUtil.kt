package com.myself.kotlinplayer.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * @Created by Jams
 * @Created time 2021/10/7 16:30
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/7 16:30
 * @dese todo
 */
object DateFormatUtil{
    open val YYMMDD = "yyyy-MM-dd"
    fun format(date:String, format: String): String {
        val formatter = SimpleDateFormat(format)
        val temp = formatter.parse(date)
        val result = formatter.format(temp)
        return result
    }

}