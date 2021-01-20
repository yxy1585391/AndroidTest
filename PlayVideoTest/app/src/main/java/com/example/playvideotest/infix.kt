package com.example.playvideotest

infix fun String.beginsWith(prefix: String) = startsWith(prefix)

infix fun <T> Collection<T>.has(element: T) = contains(element)

fun main() {
    val list = listOf("Apple","banana","Orange")
    if (list has "banana") {
        //处理逻辑
    }
}