package com.example.androidthreadtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val updateText = 1
    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            //在这里进行UI操作
            when(msg.what) {
                updateText -> textView.text = "Nice to meet you"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeTextButton.setOnClickListener {
            //错误写法
//            thread {
//                textView.text = "Nice to meet you"
//            }

            thread {
                val msg = Message()
                msg.what = updateText
                handler.sendMessage(msg) //将Message对象发送出去
            }
        }
    }
}