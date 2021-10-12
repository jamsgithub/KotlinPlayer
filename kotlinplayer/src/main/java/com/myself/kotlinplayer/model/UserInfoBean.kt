package com.myself.kotlinplayer.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @Created by Jams
 * @Created time 2021/10/11 15:09
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/11 15:09
 * @dese todo
 */
data class UserInfoBean(
    val userId: String?,
    val username: String?,
    val password: String?,
    val email: String?,
    val empNum: String?,
    val cellphone: String?,
    val position: String?,
    val lx: String?,
    val identityList: List<IdentityListBean> = ArrayList()
)