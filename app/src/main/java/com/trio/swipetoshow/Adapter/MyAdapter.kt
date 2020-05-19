package com.trio.swipetoshow.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.trio.swipetoshow.Model.Item
import com.trio.swipetoshow.R

class MyAdapter( internal var context:Context, internal var itemList:MutableList<Item>):
        RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.rcyclerview_view_row,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(itemList[position].image).into(holder.txt_cart_img);
        holder.txt_cart_comment.text = itemList[position].commet;
        holder.txt_cart_name.text = itemList[position].username;
        holder.txt_cart_commetDate.text = itemList[position].commnetDate;
    }

}