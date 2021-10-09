package com.myself.kotlinplayer.utils

/**
 * @Created by Jams
 * @Created time 2021/10/7 16:27
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/7 16:27
 * @dese todo
 */
object TextUtil {
    fun colorFormatString(text: String?, color: Int): String? {
        return String.format("<font color=\"#%x\">%s</font>", color, text)
    }
}