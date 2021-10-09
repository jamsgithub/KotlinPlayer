package com.myself.kotlinplayer.utils

import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.base.BaseFragment
import com.myself.kotlinplayer.ui.fragment.HomeFragment
import com.myself.kotlinplayer.ui.fragment.MvFragment
import com.myself.kotlinplayer.ui.fragment.VBangFragment
import com.myself.kotlinplayer.ui.fragment.YueDanFragment

/**
 * @Created by Jams
 * @Created time 2021/10/5 14:28
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 14:28
 * @dese todo
 */
class FragmentUtils private constructor(){
    private val homeFragment by lazy { HomeFragment() }
    private val mvFragment by lazy { MvFragment() }
    private val vBangFragment by lazy { VBangFragment() }
    private val yueDanFragment by lazy { YueDanFragment() }

    companion object{
        val fragmentUtils by lazy { FragmentUtils() }
    }

    fun getFragmentById(tabId:Int): BaseFragment?{
        when(tabId){
            R.id.tab_home->return homeFragment
            R.id.tab_mv-> return mvFragment
            R.id.tab_vbang->return vBangFragment
            R.id.tab_yuedan->return yueDanFragment
        }
        return null
    }
}