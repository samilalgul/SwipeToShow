package com.trio.swipetoshow.Adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rcyclerview_view_row.view.*

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    var txt_cart_name : TextView
    var txt_cart_comment : TextView
    var txt_cart_commetDate : TextView
    var txt_cart_img : ImageView

    init {
        txt_cart_name = itemView.recycleruserName
        txt_cart_comment = itemView.recyclerComment
        txt_cart_commetDate = itemView.commentDate
        txt_cart_img = itemView.img_user
    }
}