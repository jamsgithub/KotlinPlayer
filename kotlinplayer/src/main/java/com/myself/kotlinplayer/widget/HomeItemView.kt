package com.myself.kotlinplayer.widget

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.text.Html
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.myself.kotlinplayer.R
import com.myself.kotlinplayer.model.HomeItemBean
import com.myself.kotlinplayer.utils.ColorUtil
import com.myself.kotlinplayer.utils.DateFormatUtil
import com.myself.kotlinplayer.utils.TextUtil
import kotlinx.android.synthetic.main.item_home_layout.view.*
import org.jetbrains.anko.textColor


/**
 * @Created by Jams
 * @Created time 2021/10/5 15:21
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/5 15:21
 * @dese todo
 */
class HomeItemView : RelativeLayout {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_home_layout, this)
    }

    fun setData(itemData: HomeItemBean) {
        (priority_text.background as GradientDrawable).setColor(
            context.resources.getColor(
                ColorUtil.getColorIdByHjdm(itemData.hjDm)
            )
        )

        priority_text.text = itemData.hjMc
        doc_title.text = itemData.bt
        doc_no.text = itemData.wjbh

        val sendPerson =
            context.resources.getString(R.string.doc_send_person) + " " + TextUtil.colorFormatString(
                itemData.fsrymc,
                context.resources.getColor(R.color.darkGrayColor)
            )
        doc_send_person.text= Html.fromHtml(sendPerson)

        doc_send_time.text = Html.fromHtml(context.resources.getString(R.string.doc_send_time) + " " + TextUtil.colorFormatString(
            DateFormatUtil.format(itemData.ddsj1, DateFormatUtil.YYMMDD),
            context.resources.getColor(R.color.darkGrayColor)
        ))

        doc_title.textColor = context.resources.getColor(R.color.font_main)

        red_dot.visibility = View.GONE

        remind_content.visibility = View.GONE

    }






}