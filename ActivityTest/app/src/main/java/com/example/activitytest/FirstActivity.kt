package com.example.activitytest

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.first_layout.*
import java.lang.StringBuilder
import java.net.URI

class FirstActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
//        //通过findViewById获取布局文件中定义的元素
//        val button1: Button = findViewById(R.id.button1)
//        //注册监听器
//        button1.setOnClickListener {
//            /*
//            context 上下文
//            text    显示的内容
//            第三个参数是显示的时长
//            * */
//            Toast.makeText(this,"You clicked Button 1",Toast.LENGTH_SHORT).show()
//        }


        /*
        * kotlin-android-extensions插件根据布局文件中定义的id自动生成一个相同名称的变量
        * */
        button1.setOnClickListener {
//            Toast.makeText(this,"You clicked Button 1",Toast.LENGTH_SHORT).show()

            /*
            * 第一个参数提供一个启动Activity的上下文
            * 第二个参数class用于指定想要启动的目标Activity
            * */
//            val intent = Intent(this,SecondActivity::class.java)
//
//            startActivity(intent)

            //隐式Intent
//            val intent = Intent("com.example.activitytest.ACTION_START")
//            intent.addCategory("com.example.activitytest.MY_CATEGORY")
//            startActivity(intent)

            //打开一个网页
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)

            //打开拨号界面
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:10086")
//            startActivity(intent)

//            //传值
//            val data = "Hello SecondActivity"
//            val intent = Intent(this,SecondActivity::class.java)
//            intent.putExtra("extra_data",data)
//            startActivity(intent)

            //从下一个界面返回值给上一个界面
//            val intent = Intent(this,SecondActivity::class.java)
//            //requestCode 用于在之后回调中判断数据的来源
//            startActivityForResult(intent,1)

//            SecondActivity.actionStart(this,"data1","data2")

//            val intent = Intent(this,SecondActivity::class.java).apply {
//                putExtra("param1","data1")
//                putExtra("param2","data2")
//            }
//            startActivity(intent)

//            val inputText = editText.text.toString()
//            Toast.makeText(this,inputText,Toast.LENGTH_SHORT).show()

            //动态更改图片
//            imageView.setImageResource(R.drawable.ic_launcher_foreground)

            //进度条是否可见
//            if (progressBar.visibility == View.VISIBLE) {
//                progressBar.visibility = View.GONE
//            }else{
//                progressBar.visibility = View.VISIBLE
//            }

            //改变进度条的进度
//            progressBar.progress = progressBar.progress + 10

            //对话框
            AlertDialog.Builder(this).apply {
                setTitle("This is dialog")
                setMessage("Something important.")
                setCancelable(false)
                setPositiveButton("OK") {
                    dialog, which ->
                }
                setNegativeButton("Cancel") {
                    dialog, which ->
                }
                show()
            }
        }
    }

    //如果用startActivityForResult启动Activity 那么就要重写改方法
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val returnedData = data?.getStringExtra("data_return")
                Log.d("FirstActivity","returned data is $returnedData")
            }
        }
    }

    //添加菜单
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        /*
        menuInflater实际上调用了父类的getMenuInflater方法获取到一个MenuInflater对象
        再调用inflate方法就可以给当前Activity创建菜单
        menu表示菜单添加到哪个Menu对象中
        * */
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    //菜单的点击事件
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.add_item -> Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }

    fun test() {
        val list = listOf("Apple","Banana","Orange","Pear")
        val builder = StringBuilder()
        builder.append("Start eating fruits.\n")
        for (fruit in list) {
            builder.append(fruit).append("\n")
        }
        builder.append("Ate all fruits")
        val result = builder.toString()
        println(result)
    }

    fun test1() {
        val list = listOf("Apple","Banana","Orange","Pear")
        val result = with(StringBuilder()) {
            append("Start eating fruits.\n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("Ate all fruits")
            toString()
        }
        println(result)
    }

    fun test2() {
        val list = listOf("Apple","Banana","Orange","Pear")
        val result = StringBuilder().run {
            append("Start eating fruits.\n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("Ate all fruits")
            toString()
        }
        println(result)
    }

    fun test3() {
        val list = listOf("Apple","Banana","Orange","Pear")
        val result = StringBuilder().apply {
            append("Start eating fruits.\n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("Ate all fruits")
        }
        println(result.toString())
    }
}