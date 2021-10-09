package com.myself.kotlinplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.adapter.HomeAdapter
import com.myself.kotlinplayer.base.*
import com.myself.kotlinplayer.model.HomeItemBean
import com.myself.kotlinplayer.presenter.impl.HomePresenterImpl
import com.myself.kotlinplayer.view.HomeView
import com.myself.kotlinplayer.widget.HomeItemView
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.runOnUiThread
import java.io.IOException
import kotlin.math.log

/**
 * @Created by Jams
 * @Created time 2021/10/5 9:16
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 9:16
 * @dese todo
 */
class HomeFragment:BaseListFragment<List<HomeItemBean>, HomeItemBean, HomeItemView>(){
    override fun getList(response: List<HomeItemBean>): List<HomeItemBean> {
        return response
    }

    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return HomeAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)
    }

    override fun onItemClick(itemBean: HomeItemBean) {
        Log.i("onItemClick",itemBean.toString())
    }

}