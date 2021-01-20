package com.example.notificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1) {
            val channel = NotificationChannel("normal","Normal",NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)

            val channel2 = NotificationChannel("important","Important",NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }
        sendNotice.setOnClickListener {
            val intent = Intent(this,NotificationActivity::class.java)
            val pi = PendingIntent.getActivity(this,0,intent,0)
            val notification = NotificationCompat.Builder(this,"important")
                    .setContentTitle("This is content title")
//                    .setContentText("This is content text")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.ic_launcher_background))
                    .setContentIntent(pi)
//                    .setStyle(NotificationCompat.BigTextStyle().bigText("This is content text,This is content text," +
//                            "This is content text,This is content text,This is content text"))
                    .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources,
                    R.drawable.ic_launcher_background)))
//                    .setAutoCancel(true) //取消通知
                    .build()
            manager.notify(1,notification)
        }
    }
}

/*
* 如果通知内容过多 使用setContentText  内容会显示不全 使用setStyle
*setStyle(NotificationCompat.BigTextStyle().bigText("This is content text,This is content text," +
                            "This is content text,This is content text,This is content text"))
  还可以使用setStyle显示大图
* */