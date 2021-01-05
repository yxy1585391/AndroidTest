package com.example.activitytest

class Util {
    fun doAction1() {
        println("do action1")
    }

    companion object {
        @JvmStatic //使得这个方法变成真正的类方法 静态方法
        fun doAction2() {
            println("do action2")
        }
    }


}