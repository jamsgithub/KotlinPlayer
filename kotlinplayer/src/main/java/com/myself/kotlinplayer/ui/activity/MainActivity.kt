package com.myself.kotlinplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.base.BaseActivity
import com.myself.kotlinplayer.mgr.ToolBarManager
import com.myself.kotlinplayer.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find


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

    override val toolBar by lazy {
        find<Toolbar>(R.id.toolbar)
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
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





}
