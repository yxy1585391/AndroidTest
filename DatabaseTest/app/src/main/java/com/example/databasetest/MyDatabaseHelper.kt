package com.example.databasetest

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class MyDatabaseHelper(private val context: Context, name: String, version: Int): SQLiteOpenHelper(context,name,null,version) {

//    private val createBook = "create table Book (" +
//            " id integer primary key autoincrement," +
//            "author text," +
//            "price real," +
//            "pages integer," +
//            "name text)"

    private val createBook = "create table Book (" +
            " id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "pages integer," +
            "name text," +
            "category_id integer)"

    private val createCategory = "create table Category (" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)
        db?.execSQL(createCategory)
        Toast.makeText(context,"Create succeeded",Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db?.execSQL("drop table if exists Book")
//        db?.execSQL("drop table if exists Category")
//        onCreate(db)
        if (oldVersion <= 1) {
            db?.execSQL(createCategory)
        }
        if (oldVersion <= 2) {
            db?.execSQL("alter table Book add column category_i integer")
        }
    }

    fun getTableAsString(db: SQLiteDatabase, tableName: String): String? {
        Log.i("TAG", "getTableAsString called")
        var tableString = String.format("Table %s:\n", tableName)
        val allRows: Cursor = db.rawQuery("SELECT * FROM $tableName", null)
        if (allRows.moveToFirst()) {
            val columnNames: Array<String> = allRows.getColumnNames()
            do {
                for (name in columnNames) {
                    tableString += java.lang.String.format(
                            "%s: %s\n", name,
                            allRows.getString(allRows.getColumnIndex(name))
                    )
                }
                tableString += "\n"
            } while (allRows.moveToNext())
        }
        return tableString
    }
}