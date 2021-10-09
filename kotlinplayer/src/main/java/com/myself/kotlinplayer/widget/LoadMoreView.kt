package com.myself.kotlinplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.myself.kotlinplayer.R

/**
 * @Created by Jams
 * @Created time 2021/10/7 18:21
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/7 18:21
 * @dese todo
 */
class LoadMoreView : RelativeLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.load_more_view, this)
    }
}