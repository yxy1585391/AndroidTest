package com.example.uibespractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //没有被初始化
        if (!::adapter.isInitialized) {

        }
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        recyclerView.adapter = adapter
        send.setOnClickListener {
             val content = inputText.text.toString()
            if (content.isNotEmpty()) {
                val msg = Msg(content,Msg.TYPE_SEND)
                msgList.add(msg)
                adapter?.notifyItemInserted(msgList.size-1)//当有新消息时 刷新recyclerView中的显示
                recyclerView.scrollToPosition(msgList.size-1)//定位到最后一行
                inputText.setText("")
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("hello guy.",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("hello.who is that?",Msg.TYPE_SEND)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}