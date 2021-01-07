package com.example.broadcasttest

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context,"received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show()
        Log.i("TAG","received in MyBroadcastReceiver")
//        如果是在onReceive中调用了abortBroadcast()方法 那么就表示将这条广播截断 后面的BroadcastReceiver将无法再接受到这条广播
        abortBroadcast()
    }
}