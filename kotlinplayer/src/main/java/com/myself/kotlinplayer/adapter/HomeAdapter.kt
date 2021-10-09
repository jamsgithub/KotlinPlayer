package com.myself.kotlinplayer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.myself.kotlinplayer.base.BaseListAdapter
import com.myself.kotlinplayer.model.HomeItemBean
import com.myself.kotlinplayer.widget.HomeItemView
import com.myself.kotlinplayer.widget.LoadMoreView

/**
 * @Created by Jams
 * @Created time 2021/10/5 9:22
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 9:22
 * @dese todo
 */
class HomeAdapter() : BaseListAdapter<HomeItemBean, HomeItemView>() {
    override fun refreshItemData(itemView: HomeItemView, itemData: HomeItemBean) {
        itemView.setData(itemData)
    }

    override fun getItemView(context: Context?): HomeItemView {
        return HomeItemView(context)
    }

}