package com.myself.kotlinplayer.base

import android.content.Context
import android.widget.Toast
import com.myself.kotlinplayer.model.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @Created by Jams
 * @Created time 2021/10/11 20:50
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/10/11 20:50
 * @dese todo
 */
abstract class  BaseCallBack<BEAN>(val context: Context) : Callback<BaseModel<BEAN>> {
    override fun onFailure(call: Call<BaseModel<BEAN>>, t: Throwable) {
        t.message?.let { toast(it) }
    }

    override fun onResponse(call: Call<BaseModel<BEAN>>, response: Response<BaseModel<BEAN>>) {
        if (response.isSuccessful) {
           val body = response.body()
            if (body.code == 100) {
                val data = body.data
                onSuccess(data)
            }else if (body.code == 101){
                body.message?.let { toast(it) }
            }
        }
    }

    abstract fun onSuccess(bean: BEAN)

    private fun toast(msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}