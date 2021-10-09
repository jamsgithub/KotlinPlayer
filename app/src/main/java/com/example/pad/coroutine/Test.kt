package com.example.pad.coroutine
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * @Created by Jams
 * @Created time 2021/9/26 10:03
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2021/9/26 10:03
 * @dese 运行不能被取消的协程
 */
/*fun main() = runBlocking{
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            // 使用withContext(NonCancellable) 挂起一个被取消的协程
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    println("main: Now I can quit.")
}*/

suspend fun performRequest(request: Int): String {
    delay(1000) // 模仿长时间运行的异步工作
    return "response $request"
}

fun main() = runBlocking<Unit> {
    /*(1..3).asFlow() // 一个请求流
        .map { request -> performRequest(request) }
        .collect{response -> println(response)}*/

    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it % 2 == 0
        }
        .map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }

}



