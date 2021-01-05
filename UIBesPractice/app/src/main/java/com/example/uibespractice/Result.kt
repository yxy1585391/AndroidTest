package com.example.uibespractice

import java.lang.IllegalArgumentException

////普通类
//interface Result
//class Success(val msg: String): Result
//class Failure(val error: String): Result
//
//fun getResltMsg(result: Result) = when(result) {
//    is Success -> result.msg
//    is Failure -> result.error
//    else -> throw IllegalArgumentException()
//}


//密封类
sealed class Result
class Success(val msg: String): Result()
class Failure(val error: String): Result()

fun getResltMsg(result: Result) = when(result) {
    is Success -> result.msg
    is Failure -> result.error
}