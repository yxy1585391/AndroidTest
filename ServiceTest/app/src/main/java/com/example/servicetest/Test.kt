package com.example.servicetest

inline fun <reified T> getGenericType() = T::class.java



open class Person(val name: String, val age: Int)
class Student(name: String, age: Int): Person(name,age)
class Teacher(name: String, age: Int): Person(name,age)

class SimpleData<out T>(private val data: T?) {
    fun get(): T? {
        return data
    }
}


fun main() {
//    val result1 = getGenericType<String>()
//    val result2 = getGenericType<Int>()
//    println("result1 is $result1")
//    println("result2 is $result2")

    val student = Student("Tom",19)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()
}

fun handleMyData(data: SimpleData<Person>) {
    val peronData = data.get()
}
