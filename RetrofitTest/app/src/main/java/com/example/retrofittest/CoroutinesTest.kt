package com.example.retrofittest

import android.provider.Settings
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {
//    GlobalScope.launch {
//        println("codes run in coroutine scope")
//    }
//    Thread.sleep(1000)

//    runBlocking {
//        println("codes run in coroutine scope")
//        delay(1500)
//        println("codes run in coroutine scope")
//    }

//    runBlocking {
////        子协程
//        launch {
//            println("launch1")
//            delay(1000)
//            println("launch1 finished")
//        }
//
//        launch {
//            println("launch2")
//            delay(1000)
//            println("launch2 finished")
//        }
//    }

//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000) {
//            launch {
//                println(".")
//            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)

//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        //具体逻辑
//    }
//    job.cancel()
//
//    runBlocking {
//        val result = async {
//            5 + 5
//        }.await()
//        println(result)
//    }

//    runBlocking {
//        val start = System.currentTimeMillis()
//        val result = async {
//            delay(1000)
//            5 + 5
//        }.await()
//        val result2 = async {
//            delay(1000)
//            4 + 6
//        }.await()
//        println("result is ${result + result2}.")
//        val end = System.currentTimeMillis()
//        println("cost ${end - start} ms.")
//    }

    runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000)
            5 + 5
        }

        val deferred2 = async {
            delay(1000)
            4 + 6
        }
        println("result is ${deferred1.await() + deferred2.await()}.")
        val end = System.currentTimeMillis()
        println("cost ${end - start} ms.")
    }
}

//suspend fun printDot() {
//    println(".")
//    delay(1000)
//}

suspend fun printDot() = coroutineScope {
    launch {
        println(".")
        delay(1000)
    }
}

suspend fun request(address: String): String {
    return suspendCoroutine {continuation ->

    }
}

suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine {continuation ->
        enqueue(object : Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) continuation.resume(body)
                else
                    continuation.resumeWithException(RuntimeException("response body is null"))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }
}