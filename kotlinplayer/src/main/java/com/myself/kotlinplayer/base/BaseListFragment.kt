package com.myself.kotlinplayer.base

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.myself.kotlinplayer.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @Created by Jams
 * @Created time 2021/10/8 14:59
 * @dese 需要泛型的
 *        HomeView
 *        Adapter
 *        Presenter
 *
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 14:59
 * @dese todo
 */
abstract class BaseListFragment<RESPONSE,ITEMBEAN, ITEMVIEW:View> : BaseFragment(), BaseView<RESPONSE> {
    val adapter by lazy {  getSpecialAdapter() }
    var curPage = 1;
    private val presenter by lazy { getSpecialPresenter() }

    override fun viewLayoutId(): Int {
        return R.layout.fragment_home;
    }

    override fun initListener() {
        val layoutManager = LinearLayoutManager(context)
        home_recyclerview.layoutManager = layoutManager
        home_recyclerview.adapter = adapter

        refreshLayout.setOnRefreshListener {
            curPage = 1
            loadDatas(curPage)
        }

        home_recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    val manager = recyclerView.layoutManager
                    if (manager is LinearLayoutManager) {
                        val lastVisiblePos = manager.findLastVisibleItemPosition();
                        if (lastVisiblePos == (adapter?.itemCount?.minus(1))) {
                            curPage++;
                            loadDatas(curPage);
                        }
                    }
                }
            }
        })

        adapter.setItemListenerFun {
            onItemClick(it)
        }
    }

    override fun initData() {
        loadDatas(curPage)
    }

    private fun loadDatas(curPage: Int){
        presenter.fetchDatas(curPage)
    }

    override fun onError(msg: String?) {
        if (curPage == 1) {
            refreshLayout.isRefreshing = false
        }
        msg?.let { myToast(it) }

    }

    override fun onResponse(response: RESPONSE, curPage: Int) {
        if (curPage == 1){
            refreshLayout.isRefreshing = false
            adapter?.setDatas(getList(response))
        }else{
            adapter?.loadMore(getList(response))
        }
    }

    /**
     * 解绑view
     */
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.destroyView()
    }

    abstract fun getList(response: RESPONSE):List<ITEMBEAN>

    abstract fun getSpecialAdapter():BaseListAdapter<ITEMBEAN,ITEMVIEW>

    abstract fun getSpecialPresenter():BaseListPresenter

    abstract fun onItemClick(itemBean: ITEMBEAN);


}