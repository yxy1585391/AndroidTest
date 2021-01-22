package com.example.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        navView.setCheckedItem(R.id.nvaCall)//设置为默认选中
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        fab.setOnClickListener {
            Toast.makeText(this,"FAB clicked",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
            R.id.backup -> Toast.makeText(this,"You clicked Backup",Toast.LENGTH_SHORT).show()
            R.id.delete -> Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this,"You clicked Settings",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}