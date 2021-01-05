package com.example.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        /*
        savedInstanceState 如果你在Activity被系统回收之前 通过onSaveInstanceState方法保存了数据
        这个参数就会带有之前保存的全部数据 只需要通过相应的取值方法取出数据即可
        * */
        super.onCreate(savedInstanceState)
        //取出数据
        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("data_key")
            Log.d(tag,"tempData is $tempData")
        }
        Log.d(tag,"onCreate")
        setContentView(R.layout.activity_main)
        startNormalActivity.setOnClickListener {
            val intent = Intent(this,NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener {
            val intent = Intent(this,DialogActivity::class.java)
            startActivity(intent)
        }
    }

    //保证在Activity被回收之前一定会被调用
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val tempData = "Something you just typed"
        outState.putString("data_key",tempData)
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag,"onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag,"onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag,"onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag,"onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag,"onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag,"onRestart")
    }
}