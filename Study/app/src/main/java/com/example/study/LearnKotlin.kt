package com.example.study

import kotlin.math.max

fun main() {
//    println("Hello kotlin")
//    var a: Int = 10
//    a *= 10
//    println("a = $a")
//    val a = 37
//    val b = 48
//    val value = largeNumber(a,b)
//    println("large number is $value")

//    val num = 10L
//    checkNumber(num)

//    for (i in 0..10) {
//        println(i)
//    }

    /*升序区间*/
//    for (i in 0 until 10 step 2) {
//        println(i)
//    }
    /*降序区间*/
    for (i in 10 downTo 1 step 2) {
        println(i)
    }
}

fun largeNumber(num1: Int, num2: Int): Int {
    return max(num1,num2)
}

fun largeNumber1(num1: Int, num2: Int): Int = max(num1,num2)

fun largeNumber2(num1: Int, num2: Int) = max(num1,num2)

fun largeNumber3(num1: Int, num2: Int): Int {
    return if (num1 > num2) {
        num1
    }else{
        num2
    }
}

fun largeNumber4(num1: Int, num2: Int) = if (num1 > num2) {
    num1
}else{
    num2
}

fun getScore(name: String) = if (name == "Tom") {
    86
}else if (name == "Jim") {
    77
}else if (name == "jack") {
    96
}else {
    0
}

fun getScore1(name: String) = when(name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 96
    else -> 0
}

/*
* Number是抽象类
* Int Long Double Float都是他的子类
* */

fun checkNumber(num: Number) {
    when(num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number is not support")
    }
}

/*
* 判断字符串或者对象释放相等可以直接使用==关键字
* */

fun getScore2(name: String) = when {
    name == "Tom" -> 86
    name == "Jim" -> 78
    name == "jack" -> 95
    else -> 0
}

fun getScore3(name: String) = when {
    name.startsWith("Tom") -> 86
    name == "Jim" -> 78
    name == "jack" -> 95
    else -> 0
}