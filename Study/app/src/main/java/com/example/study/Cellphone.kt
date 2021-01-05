package com.example.study

/*
* 当你在一个类前面声明了data关键字 表面你希望这个类是一个数据类
* kotlin会根据主构造函数中的参数帮你将equals() hashCode() toString()等规定且无实际逻辑意义的方法自动生成 减少了开发的工作量
* */

data class Cellphone(val brand: String, val price: Double)

fun main() {
    val cellphone1 = Cellphone("Samsung",1299.99)
    val cellphone2 = Cellphone("Samsung",1299.99)
    println(cellphone1)
    println("cellphone1 equals cellphone2" + (cellphone1 == cellphone2))
}

