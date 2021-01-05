package com.example.study

/*
* kotlin的任何一个非抽象类是不可以被继承的
* 想要类可以被继承 需在类前面加上open关键字
* */
open class Person(val name: String, val age: Int) {
    fun eat() {
        println(name + "is eating. He is" + age + " years old")
    }

}

fun main() {
    printParams(str = "ae")
}

fun test() {
    /*listOf创建的是一个不可变集合
    * */
    val list = listOf("Apple","Banana","Orange","Pear")
    for (fruit in list) {
        println(fruit)
    }
    val maxLengthFruit = list.maxBy { it.length }
    println("max length fruit is $maxLengthFruit")

    //mutableListOf是可变的集合
    val muList = mutableListOf("Apple","Banana","Orange","Pear")
    muList.add("Grape")
    for (fruit in muList) {
        println(fruit)
    }

    //set集合底层是使用hash映射机制来存放数据的 无法保证数据有序
    val set = setOf("Apple","Banana","Orange","Pear")
    for (fruit in set) {
        println(fruit)
    }

    //Map是一种键值对形式的数据结构
    val map = HashMap<String,Int>()
    map["Apple"] = 1
    map["Banana"] = 2
    map["Orange"] = 3

    //to 不是关键字 是一个infix函数
    val map1 = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3)
    for ((fruit,number) in map1) {
        println("fruit is $fruit, number is $number")
    }
}

fun test1() {
    val list = listOf("Apple","Banana","Orange","Pear")
    val maxLengthFruit = list.maxBy { it.length }
    println("max length fruit is $maxLengthFruit")
}

fun test2() {
    //map可以将集合中的每个元素都映射成另外的值 映射规则在lambda表达式中指定 最终生成一个新的集合
    val list = listOf("Apple","Banana","Orange","Pear")
    val newList = list.map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }
}

fun test3() {
    val list = listOf("Apple","Banana","Orange","Pear","Grape","Watermelon")
    val newList = list.filter { it.length <= 5 }
        .map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }
}

fun test4() {
    /*
    any是判断集合中是否至少存在一个元素满足指定条件
    all函数用于判断集合中是否所有元素都满足指定条件
    * */
    val list = listOf("Apple","Banana","Orange","Pear","Grape","Watermelon")
    val anyResult = list.any { it.length <= 5 }
    val allResult = list.all { it.length <= 5 }
    println("anyResult is $anyResult, allResult is $allResult")
}

fun test5() {
    Thread(object : Runnable {
        override fun run() {
            println("Thread is running")
        }
    }).start()

    Thread(Runnable { println("Thread is running") }).start()

    Thread{ println("Thread is running") }.start()
}

fun printParams(num: Int = 100, str: String) {
    println("num is $num, str is $str")
}

