package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listviewtest.Fruit
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFruits()
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL 水平布局

        //瀑布流式布局 指定布局的列数
        val layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        //layoutManager指定recyclerview的布局方式
        recyclerview.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerview.adapter = adapter
    }


//    private fun initFruits() {
//        repeat(2) {
//            fruitList.add(Fruit("Apple", R.drawable.apple_pic))
//            fruitList.add(Fruit("Banana", R.drawable.banana_pic))
//            fruitList.add(Fruit("Orange", R.drawable.orange_pic))
//            fruitList.add(Fruit("Watermelon", R.drawable.watermelon_pic))
//            fruitList.add(Fruit("Pear", R.drawable.pear_pic))
//            fruitList.add(Fruit("Grape", R.drawable.grape_pic))
//            fruitList.add(Fruit("Pineapple", R.drawable.pineapple_pic))
//            fruitList.add(Fruit("Strawberry", R.drawable.strawberry_pic))
//            fruitList.add(Fruit("Cherry", R.drawable.cherry_pic))
//            fruitList.add(Fruit("Mango", R.drawable.mango_pic))
//        }
//    }

    private fun initFruits() {
        repeat(2) {
            fruitList.add(Fruit(getRandomLengthString("Apple"),R.drawable.apple_pic))
            fruitList.add(Fruit(getRandomLengthString("Banana"),R.drawable.banana_pic))
            fruitList.add(Fruit(getRandomLengthString("Orange"), R.drawable.orange_pic))
            fruitList.add(Fruit(getRandomLengthString("Watermelon"), R.drawable.watermelon_pic))
            fruitList.add(Fruit(getRandomLengthString("Pear"), R.drawable.pear_pic))
            fruitList.add(Fruit(getRandomLengthString("Grape"), R.drawable.grape_pic))
            fruitList.add(Fruit(getRandomLengthString("Pineapple"), R.drawable.pineapple_pic))
            fruitList.add(Fruit(getRandomLengthString("Strawberry"), R.drawable.strawberry_pic))
            fruitList.add(Fruit(getRandomLengthString("Cherry"), R.drawable.cherry_pic))
            fruitList.add(Fruit(getRandomLengthString("Mango"), R.drawable.mango_pic))
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        return with(StringBuilder()) {
            repeat(n) {
                append(str)
            }
            toString()
        }
    }

}