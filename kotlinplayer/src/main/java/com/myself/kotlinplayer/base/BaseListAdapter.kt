package com.myself.kotlinplayer.base

import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.myself.kotlinplayer.widget.LoadMoreView

/**
 * @Created by Jams
 * @Created time 2021/10/8 15:12
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 15:12
 * @dese todo
 */
abstract class BaseListAdapter<ITEMBEAN, ITEMVIEW:View>(): RecyclerView.Adapter<BaseListAdapter.BaseListHolder>() {
    private var list = arrayListOf<ITEMBEAN>()

    fun setDatas(homeItemBeans: List<ITEMBEAN>) {
        this.list.clear()
        this.list = homeItemBeans as ArrayList<ITEMBEAN>
        notifyDataSetChanged()
    }

    fun loadMore(homeItemBeans: List<ITEMBEAN>?){
        homeItemBeans?.let {
            this.list.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListHolder {
        if (viewType == 1){
            return BaseListHolder(LoadMoreView(parent.context))
        }
        return BaseListHolder(getItemView(parent.context))
    }



    override fun getItemCount(): Int {
        return this.list.size + 1;
    }

    override fun getItemViewType(position: Int): Int {
        // 上拉刷新
        if (position == list.size){
            return 1
        }
        return 0
    }

    override fun onBindViewHolder(holder: BaseListHolder, position: Int) {
        if (position == list.size) return
        val itemData = list[position]
        val itemView = holder.itemView as ITEMVIEW
        refreshItemData(itemView, itemData)
        //itemView.setData(itemData)
        itemView.setOnClickListener { listenerFun?.let { it(itemData) }}
    }

    class BaseListHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    private var listenerFun:((itemBean:ITEMBEAN)->Unit)? = null;

    fun setItemListenerFun(listener:((itemBean: ITEMBEAN)->Unit)?){
        this.listenerFun = listener
    }


    abstract fun refreshItemData(itemView: ITEMVIEW, itemData:ITEMBEAN)
    abstract fun getItemView(context: Context?): ITEMVIEW
}