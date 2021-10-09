package com.myself.kotlinplayer.net

import com.myself.kotlinplayer.base.BaseRequest
import com.myself.kotlinplayer.model.HomeListInfo
import okhttp3.FormBody

/**
 * @Created by Jams
 * @Created time 2021/10/8 12:01
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/8 12:01
 * @dese todo
 */
class HomeRequest(override val url:String, override val formBody: FormBody,
                  override val handler: ResponseHandler<HomeListInfo>):
    BaseRequest<HomeListInfo>(url, formBody, handler)
