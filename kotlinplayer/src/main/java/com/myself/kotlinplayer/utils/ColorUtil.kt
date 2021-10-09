package com.myself.kotlinplayer.utils

import com.myself.kotlinplayer.R

/**
 * @Created by Jams
 * @Created time 2021/10/7 16:14
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/7 16:14
 * @dese todo
 */
object ColorUtil {

    fun getColorIdByHjdm(hjdm:String):Int {
        when(hjdm){
            "01"-> return R.color.doc_normal
            "02"-> return R.color.doc_normal_critical
            "03"-> return R.color.doc_critical
            "04"-> return R.color.doc_very_critical
            "05"-> return R.color.doc_most_critical
            "06"-> return R.color.doc_must
        }
        return R.color.doc_normal
    }



}