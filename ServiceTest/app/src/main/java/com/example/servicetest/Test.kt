package com.example.servicetest

inline fun <reified T> getGenericType() = T::class.java

fun main() {
    val result1 = getGenericType<String>()
    val result2 = getGenericType<Int>()
    println("result1 is $result1")
    println("result2 is $result2")
}
