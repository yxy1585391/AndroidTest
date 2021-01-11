package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = MyDatabaseHelper(this,"BookStore.db",1)
//        val dbHelper = MyDatabaseHelper(this,"BookStore.db",2) //只要version比原先的大 就可以升级
        createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        addData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name","The Da Vance Code")
                put("author","Dan Brown")
                put("pages",454)
                put("price",16.96)
            }
            db.insert("Book",null,value1)
            val value2 = ContentValues().apply {
                put("name","The Lost Symbol")
                put("author","Dan Brown")
                put("pages",510)
                put("price",19.95)
            }
            db.insert("Book",null,value2)
            println(dbHelper.getTableAsString(db,"Book"))
        }
        updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("price",10.99)
            db.update("Book",values,"name = ?", arrayOf("The Da Vance Code"))
        }

        deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book","pages > ?", arrayOf("500"))
        }

        queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
            //查询Book中的所有数据
            val cursor = db.query("Book",null,null,null,null,null,null)
            if (cursor.moveToFirst()) {
                do {
                    //遍历cursor对象 取出数据并打印
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("MainActivity","book name is $name")
                    Log.d("MainActivity","book author is $author")
                    Log.d("MainActivity","book pages is $pages")
                    Log.d("MainActivity","book price is $price")
                }while (cursor.moveToNext())
            }
            cursor.close()
        }

        replaceData.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.beginTransaction() //开启事务
            try {
                db.delete("Book",null,null)
//                if (true) {
//                    //手动抛出一个异常 让事务失败
//                    throw NullPointerException()
//                }
                val values = ContentValues().apply {
                    put("name","Game of Thrones")
                    put("author","George Martin")
                    put("pages",720)
                    put("price",20.85)
                }
                db.insert("Book",null,values)
                db.setTransactionSuccessful() //事务已经执行成功
            }catch (e: IOException) {
                e.printStackTrace()
            }finally {
                db.endTransaction() //结束事务
            }
        }
    }
}