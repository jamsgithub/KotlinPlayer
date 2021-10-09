package com.example.pad.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pad.R
import com.example.pad.entity.UserInfo
import com.example.pad.services.CommonApiService
import retrofit2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("")
            .build();
        //val call:Call<UserInfo> = retrofit.create(CommonApiService);
        val service: CommonApiService = retrofit.create(CommonApiService::class.java);

        /*val userInfo:UserInfo = UserInfo("zhangsan", 18);
        userInfo.setName("lisi");
        userInfo.setAge(16);*/
        val loginCall: Call<UserInfo> = service.login("lisi", "111111")
        loginCall.enqueue(object : Callback<UserInfo> {

            override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                val userInfo = response.body();
                print("userInfo: name = ${userInfo?.getName()} , age = ${userInfo?.getAge()} ")
            }
        })






    }
}
