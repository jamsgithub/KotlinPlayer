package com.myself.kotlinplayer.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @Created by Jams
 * @Created time 2021/9/28 14:45
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/28 14:45
 * @dese todo
 */
abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initListener()
    }

    abstract fun getLayoutId():Int

    protected open fun initData(){}

    protected open fun initListener(){}

    protected fun myToast(message:String){
        runOnUiThread { toast(message) }
    }

    protected inline fun <reified T:BaseActivity> startActivityAndFinish(){
        // 使用anko的方式启动activity
        startActivity<T>()
        finish()
    }

}