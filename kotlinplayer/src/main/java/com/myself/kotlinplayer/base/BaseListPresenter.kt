package com.myself.kotlinplayer.base

/**
 * @Created by Jams
 * @Created time 2021/10/8 15:10
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 15:10
 * @dese todo
 */
interface BaseListPresenter {
    fun fetchDatas(curPage: Int)
    fun destroyView()
}