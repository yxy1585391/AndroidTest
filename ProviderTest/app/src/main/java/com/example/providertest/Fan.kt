package com.example.providertest

import kotlin.reflect.KProperty

class MyClass {
    fun <T> method(param: T): T {
        return param
    }

    fun <T: Number> method1(param: T): T {
        return param
    }

}

fun <T> T.build(block: T.() -> Unit): T {
    block()
    return this
}

class MySet<T>(private val helperSet: HashSet<T>): Set<T> {
    override val size: Int
        get() = helperSet.size

    override fun contains(element: T) = helperSet.contains(element)

    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)

    override fun isEmpty() = helperSet.isEmpty()

    override fun iterator() = helperSet.iterator()
}

class MySet2<T>(private val helperSet: HashSet<T>): Set<T> by helperSet {

    fun helloWorld() = println("Hello World")

    override fun isEmpty() = false
}



class MyClass1 {
    var p by Delegate()
}

class Delegate {

    var propValue: Any? = null
    operator fun getValue(myClass: MyClass1, prop: KProperty<*>): Any? {
        return propValue
    }

    operator fun setValue(myClass: MyClass1, prop: KProperty<*>, value: Any?) {
        propValue = value
    }

}



