package com.example.pad.utils

import kotlinx.coroutines.*

/**
 * @Created by Jams
 * @Created time 2021/9/24 11:18
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/24 11:18
 * @dese todo
 */


fun main() = runBlocking {
    val job = GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // 等待直到子协程执行结束
    println("end")
}