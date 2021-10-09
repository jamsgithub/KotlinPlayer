package com.myself.kotlinplayer.ui.activity

import android.support.v4.app.FragmentTransaction
import android.support.v7.widget.Toolbar
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.base.BaseActivity
import com.myself.kotlinplayer.mgr.ToolBarManager
import com.myself.kotlinplayer.ui.fragment.SettingFragment
import org.jetbrains.anko.find

/**
 * @Created by Jams
 * @Created time 2021/10/5 10:51
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 10:51
 * @dese todo
 */
class SettingActivity : BaseActivity(), ToolBarManager {
    override val toolBar by lazy { find<Toolbar>(R.id.toolbar) }
    override fun getLayoutId(): Int {
        return R.layout.activity_setting;
    }

    override fun initData() {
        initSettingToolBar()
    }
}


