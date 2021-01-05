package com.example.activitytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.third_layout.*

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_layout)
        button3.setOnClickListener {
            ActivityCollector.finishAll()
            //杀到当前线程
            //myPid()可以获取当前程序的进程id
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

}