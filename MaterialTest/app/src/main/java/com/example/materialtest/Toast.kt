package com.example.materialtest

import android.content.Context
import android.widget.Toast

fun String.showToast(context: Context) {
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context,this,duration).show()
}

fun Int.showToast(context: Context) {
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}

fun Int.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context,this,duration).show()
}