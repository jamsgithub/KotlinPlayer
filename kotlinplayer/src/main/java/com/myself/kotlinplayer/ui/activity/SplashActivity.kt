package com.myself.kotlinplayer.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * @Created by Jams
 * @Created time 2021/9/28 14:59
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/28 14:59
 * @dese todo
 */
class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
        // 启动缩放动画
        ViewCompat.animate(imageView).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 2000
    }

    override fun onAnimationEnd(p0: View?) {

        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(p0: View?) {
    }

    override fun onAnimationStart(p0: View?) {
    }

}