package com.example.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved",0)
        viewModel = ViewModelProvider(this,MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        plusOneButton.setOnClickListener {
            viewModel.plusOne()
        }
        clearButton.setOnClickListener {
            viewModel.clear()
        }
        refreshCounter()

        viewModel.counter.observe(this, Observer { count ->
            infoText.text = count.toString()
        })
//        lifecycle.addObserver(MyObserver())

        getUserBtn.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this, Observer { user ->
            infoText.text = user.firstName
        })

        //数据库增删改查
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom","Brady",40)
        val user2 = User("Tom","Hanks",63)
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 42
                userDao.updateUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("Hanks")
            }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d("MainActivity",user.toString())
                }
            }
        }

        doWorkBtn.setOnClickListener { it: View? ->
            val request = OneTimeWorkRequest.Builder(SimplWorker::class.java)
                .setInitialDelay(5,TimeUnit.MINUTES)
                .setBackoffCriteria(BackoffPolicy.LINEAR,10,TimeUnit.SECONDS)
//                .addTag("simple")
                .build()

            WorkManager.getInstance(this).enqueue(request)
//            WorkManager.getInstance(this).getWorkInfosByTagLiveData(request.id.toString())
//                .observe(this) { //workInfo ->
//                    if (workInfo.state == WorkInfo.state.SUCCESSED) {
//                        Log.d("MainActivity","do work successed")
//                    }else if (workInfo.state == WorkInfo.state.FAILED){
//                        Log.d("MainActivity","do work failed")
//                    }
//            }

        }
    }

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved",viewModel.counter.value ?: 0)
        }
    }

    fun getUser(userId: String): LiveData<User>{
        return Repository.getUser(userId)
    }
}