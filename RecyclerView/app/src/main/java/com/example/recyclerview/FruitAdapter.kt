package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewtest.Fruit

class FruitAdapter(private val fruitList: List<Fruit>): RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    //view通常是RecyclerView子项的最外层布局
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    //创建viewHolder实例
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fruit_item,parent,false)

        return ViewHolder(view)
    }

    //对RecyclerView子项的数据进行赋值 会在每个子项被滚动到屏幕内的时候执行
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text = fruit.name
        //设置点击事件
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"you clicked view ${fruit.name}",Toast.LENGTH_SHORT).show()
        }
        holder.fruitImage.setOnClickListener {
            Toast.makeText(holder.itemView.context,"you clicked image ${fruit.name}",Toast.LENGTH_SHORT).show()
        }
    }

    //告诉数据源的长度
    override fun getItemCount() = fruitList.size

}