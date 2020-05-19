package com.trio.swipetoshow

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trio.swipetoshow.Adapter.MyAdapter
import com.trio.swipetoshow.Listener.MyButtonClickListener
import com.trio.swipetoshow.Model.Item
import kotlinx.android.synthetic.main.activity_swipe.*

class swipeActivity : AppCompatActivity() {

    lateinit var adapter: MyAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val swipe = object: SwipeHelper(this, recyclerView, 200)
        {
            override fun instantiateMyButton(
                viewHolder: RecyclerView.ViewHolder,
                buffer: MutableList<MyButton>
            ) {
                buffer.add(MyButton(this@swipeActivity,"delete",
                    30,
                    0,
                    Color.parseColor("#FF3C30"),
                    object:MyButtonClickListener{
                        override fun onClick(pos: Int) {
                            Toast.makeText(this@swipeActivity,"DELETE ID"+ pos, Toast.LENGTH_SHORT).show()
                        }

                    }
                    ))
                buffer.add(MyButton(this@swipeActivity,"update",
                    30,
                    R.drawable.ic_edit_black_24dp,
                    Color.parseColor("#FF9502"),
                    object:MyButtonClickListener{
                        override fun onClick(pos: Int) {
                            Toast.makeText(this@swipeActivity,"Update ID"+ pos, Toast.LENGTH_SHORT).show()
                        }

                    }
                ))
            }
        }

        generateItem()
    }

    private fun generateItem() {
        val itemList = ArrayList<Item>()
        var i = 0;
        while (i < 50){
            itemList.add(Item("User 0" + ++i,
                "Commnet 0",
                "5.19.20",
                "https://image.shutterstock.com/image-vector/picture-vector-icon-image-symbol-260nw-1671415195.jpg"))
            i++
        }
        adapter = MyAdapter(this,itemList)
        recyclerView.adapter = adapter
    }
}
