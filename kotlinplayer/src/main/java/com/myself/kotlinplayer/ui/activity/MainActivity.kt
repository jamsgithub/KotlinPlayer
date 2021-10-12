package com.myself.kotlinplayer.ui.activity

import android.support.v7.widget.Toolbar
import android.util.Log
import com.myself.kotlinplayer.AUTHORIZATION
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.serviceInterface.ServiceInterface
import com.myself.kotlinplayer.base.BaseActivity
import com.myself.kotlinplayer.base.BaseCallBack
import com.myself.kotlinplayer.mgr.ToolBarManager
import com.myself.kotlinplayer.model.*
import com.myself.kotlinplayer.net.RetrofitManager
import com.myself.kotlinplayer.utils.FragmentUtils
import com.myself.kotlinplayer.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find
import retrofit2.Call


/**
 * @Created by Jams
 * @Created time 2021/9/28 14:59
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/28 14:59
 * @dese todo
 */
class MainActivity : BaseActivity() ,ToolBarManager{
    private val mContext by lazy { this.applicationContext }

    override val toolBar by lazy {
        find<Toolbar>(R.id.toolbar)
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
        login()
    }

    override fun initListener() {
        bottomBar.setOnTabSelectListener {
            val transaction = supportFragmentManager.beginTransaction()
            FragmentUtils.fragmentUtils.getFragmentById(it)?.let { fragment ->
                transaction.replace(R.id.container,
                    fragment, it.toString())
            }
            transaction.commit()
        }
    }

    fun login() {
        val retrofit = RetrofitManager.manager.create("", this.applicationContext);
        val service = retrofit.create(ServiceInterface::class.java)
        val map = HashMap<String, String>()
        map["loginName"] = "laizhenxian"
        map["password"] = "css"
        val call : Call<BaseModel<String>> = service.login(map)
        mContext?.let {
            call.enqueue(object : BaseCallBack<String>(it) {
                override fun onSuccess(bean: String) {
                    SharedPreferencesUtils(it).putString(AUTHORIZATION, bean)
                    getUserInfo()
                }

            })
        }
    }


    fun getUserInfo() {
        val retrofit = RetrofitManager.manager.create("", this.applicationContext)
        var service = retrofit.create(ServiceInterface::class.java)
        val call = service.getUserInfo();
        mContext?.let {
            call.enqueue(object : BaseCallBack<UserInfoBean>(it){
                override fun onSuccess(bean: UserInfoBean) {
                    Log.i("onSuccess", bean.toString())
                }
            })
        }
    }





}
