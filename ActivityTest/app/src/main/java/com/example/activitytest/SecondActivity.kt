package com.example.activitytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.second_layout.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)
        //从上个页面传过来的值
//        val extraData = intent.getStringExtra("extra_data")
//        Log.d("SecondActivity","extra data is $extraData")

        button2.setOnClickListener {
//            val intent = Intent()
//            intent.putExtra("data_return","Hello FirstActivity")
//            /*setResult
//            * 第一个参数用于向上一个Activity返回处理结果 一般使用RESULT_OK或者RESULT_CANCELED
//            * */
//            setResult(Activity.RESULT_OK,intent)
//            //销毁当前Activity
//            finish()
            val intent = Intent(this,ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    //当点击返回按钮的时候
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return","Hello FirstActivity")
        /*setResult
        * 第一个参数用于向上一个Activity返回处理结果 一般使用RESULT_OK或者RESULT_CANCELED
        * */
        setResult(Activity.RESULT_OK,intent)
        //销毁当前Activity
        finish()
    }

    //所有定义在companion object中的方法都可以使用类似于java静态方法的形式调用
    companion object {
        fun actionStart(context: Context, data1: String, data2: String) {
            val intent = Intent(context,SecondActivity::class.java)
            intent.putExtra("param1",data1)
            intent.putExtra("param2",data2)
            context.startActivity(intent)
        }
    }

}

