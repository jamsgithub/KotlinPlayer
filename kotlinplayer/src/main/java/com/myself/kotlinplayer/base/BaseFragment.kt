package com.myself.kotlinplayer.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * @Created by Jams
 * @Created time 2021/9/28 14:55
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/28 14:55
 * @dese todo
 */
abstract class BaseFragment : Fragment(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, viewLayoutId(), null);
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        initListener()
    }

    abstract fun viewLayoutId():Int

    protected open fun init(){}
    protected open fun initData(){}
    protected open fun initListener(){}

    protected fun myToast(message:String){
        context?.runOnUiThread { toast(message) }
    }


}