package com.example.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
* Intent 是在相互独立的组件（如两个 Activity）之间提供运行时绑定功能的对象。Intent 表示应用执行某项操作的意图
* */

/*
* AppCompatActivity是安卓提供的一种向下兼容的Activity 可以使Activity在不同的系统版本中的功能保持一致
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //给当前的Activity引入了一个布局
        setContentView(R.layout.activity_main)
    }
}