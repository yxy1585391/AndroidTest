package com.example.listviewtest

import android.app.Activity
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit>): ArrayAdapter<Fruit>(activity,resourceId,data) {

    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView) //定义内部类
    //在每个子项被滚动到屏幕内的时候会被调用
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val viewHolder: ViewHolder
        /*加载传入的布局
        * attachToRoot 代表只让我们在父布局中声明的layout属性生效 但是不会为这个view添加父布局
        * */
        //保证了ListView在快速滑动的时候不会造成性能的瓶颈
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId,parent,false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(fruitImage,fruitName)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)//获取当前项的fruit的实例
        if (fruit != null) {
//            fruitImage.setImageResource(fruit.imageId)
//            fruitName.text = fruit.name
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
}