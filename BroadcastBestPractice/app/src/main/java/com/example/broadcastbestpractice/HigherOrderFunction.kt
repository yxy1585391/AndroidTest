package com.example.broadcastbestpractice

import java.lang.StringBuilder

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int = operation(num1,num2)

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int = num1 - num2

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}


fun main() {
    val num1 = 100
    val num2 = 80
//    val result1 = num1AndNum2(num1,num2,::plus)
//    val result2 = num1AndNum2(num1,num2,::minus)
//    println("result1 is $result1")
//    println("result2 is $result2")

//    val result1 = num1AndNum2(num1,num2) { n1,n2 ->
//        n1 + n2
//    }
//    val result2 = num1AndNum2(num1,num2) { n1,n2 ->
//        n1 - n2
//    }
//    println("result1 is $result1")
//    println("result2 is $result2")
//
//    val list = listOf("Apple","Banana","Orange","Pear","Grape")
//    val result = StringBuilder().build {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//    }
//    println(result.toString())

    println("main start")
    val str = ""
    printString(str) { s ->
        println("lambda start")
        if (s.isEmpty()) return@printString
        println(s)
        println("lambda end")
    }
}