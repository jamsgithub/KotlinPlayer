package com.myself.kotlinplayer.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @Created by Jams
 * @Created time 2021/10/11 15:12
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/11 15:12
 * @dese todo
 */
data class IdentityListBean (
    val identityId: String?,
    val userId: String?,
    val identityname: String?,
    val deptId: String?,
    val xsxh: String?,
   val dept: UserInfoDeptBean?
)