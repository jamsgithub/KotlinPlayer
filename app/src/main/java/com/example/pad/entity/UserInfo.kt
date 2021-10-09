package com.example.pad.entity

/**
 * @Created by Jams
 * @Created time 2021/9/10 17:38
 * @dese 用户信息数据类
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/10 17:38
 * @dese todo
 */
data class UserInfo (val nameVal: String, val ageVal: Int){

    private var name:String=""

    private var age:Int=0;

    init {
        name = nameVal;

        age = ageVal;
    }


    fun setName(name:String) {
        this.name = name;
    }

    fun getName() :String {
        return this.name;
    }

    fun setAge(age: Int) {
        this.age = age;
    }

    fun getAge() :Int{
        return this.age;
    }

}