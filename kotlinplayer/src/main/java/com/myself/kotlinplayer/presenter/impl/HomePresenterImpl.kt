package com.myself.kotlinplayer.presenter.impl

import com.myself.kotlinplayer.base.BaseView
import com.myself.kotlinplayer.model.HomeItemBean
import com.myself.kotlinplayer.model.HomeListInfo
import com.myself.kotlinplayer.net.HomeRequest
import com.myself.kotlinplayer.net.ResponseHandler
import com.myself.kotlinplayer.presenter.interf.HomePresenter
import com.myself.kotlinplayer.view.HomeView
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull

/**
 * @Created by Jams
 * @Created time 2021/10/8 9:51
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 9:51
 * @dese todo
 */
class HomePresenterImpl(var homeView: BaseView<List<HomeItemBean>>?):HomePresenter {

    /**
     * 解绑view
     */
    override fun destroyView(){
        if (homeView == null){
            homeView = null
        }
    }



    override fun fetchDatas(curPage:Int){
        val url =
            "http://172.16.2.142:8088/download.sword?ctrl=GwglForOtherCtrl_queryDbgzForOtherDb";
        val json = "{\"rows\":20,\n" +
                "\"pageNum\":1,\n" +
                "\"identityId\":\"43436EC541AD476AAF90D164BF4A8CED\",\n" +
                "\"deptId\":\"ZR78c7445b79ecad015b7ff5d2bb10f4\",\n" +
                "\"userId\":\"ZR78c7445b9dc0ba015b9e05afa8016a\",\n" +
                "\"manufacturer\":\"HUAWEI\",\n" +
                "\"phonemodel\":\"SCM-AL09\",\n" +
                "\"macAddress\":\"e2:98:d5:0c:c7:c4\",\n" +
                "\"uniqueDeviceId\":\"280cf2e27140d30e2b641fa94341e1fef\",\n" +
                "\"androidID\":\"1cf7f920c4c444a7\",\n" +
                "\"sDKVersionName\":10,\n" +
                "\"sDKVersionCode\":29,\n" +
                "\"ABIs\":\"arm64-v8a_armeabi-v7a_armeabi\",\n" +
                "\"isDeviceRooted\":\"N\",\n" +
                "\"versionName\":\"2.0.0.8\",\n" +
                "\"VersionCode\":99,\n" +
                "\"isAdbEnabled\":true,\n" +
                "\"platform\":\"pad\"}"
        //val mediaType: MediaType? = "text/x-markdown; charset=utf-8".toMediaTypeOrNull()
        val body = FormBody.Builder()
            .add("rows", "20")
            .add("pageNum", curPage.toString())
            .add("identityId", "43436EC541AD476AAF90D164BF4A8CED")
            .add("deptId", "ZR78c7445b79ecad015b7ff5d2bb10f4")
            .add("userId", "ZR78c7445b9dc0ba015b9e05afa8016a")
            .add("manufacturer", "HUAWEI")
            .add("phonemodel", "SCM-AL09")
            .add("macAddress", "e2:98:d5:0c:c7:c4")
            .add("uniqueDeviceId", "280cf2e27140d30e2b641fa94341e1fef")
            .add("androidID", "1cf7f920c4c444a7")
            .add("sDKVersionName", "10")
            .add("sDKVersionCode", "29")
            .add("ABIs", "arm64-v8a_armeabi-v7a_armeabi")
            .add("isDeviceRooted", "N")
            .add("versionName", "2.0.0.8")
            .add("VersionCode", "99")
            .add("isAdbEnabled", "true")
            .add("platform", "pad")
            .build()

        HomeRequest(url, body, object : ResponseHandler<HomeListInfo>{
            override fun onError(message: String?) {
                homeView?.onError(message)
            }

            override fun onSuccess(homeListInfo: HomeListInfo?) {
                homeListInfo?.let {
                    homeView?.onResponse(it.data.resList, curPage)
                }
            }
        }).execute()
    }


}