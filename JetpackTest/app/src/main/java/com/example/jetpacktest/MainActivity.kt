package com.example.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

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
}