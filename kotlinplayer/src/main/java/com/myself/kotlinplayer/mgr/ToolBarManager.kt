package com.myself.kotlinplayer.mgr

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Switch
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.ui.activity.SettingActivity

/**
 * @Created by Jams
 * @Created time 2021/10/5 10:17
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 10:17
 * @dese todo
 */
interface ToolBarManager {
    val toolBar: Toolbar

    fun initMainToolBar() {
        toolBar.title = "黑马影音"
        toolBar.inflateMenu(R.menu.main)
        toolBar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.setting-> toolBar.context.startActivity(Intent(toolBar.context, SettingActivity::class.java))
                else -> println("该操作正在研发中!");
            }
            true;
        }
    }

    fun initSettingToolBar(){
        toolBar.title = "设置"
    }
}


