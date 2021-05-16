package com.example.mydemoapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_grid_view_item.view.*

class MainAdapter(
    private val exampleList: List<ExampleItem>,
    private val listener: OnItemClickListener
    ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.main_grid_view_item,
            parent,
            false
        )
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.textView.setText(getTextFromId(position))
        holder.imageView.setImageResource(currentItem.imageResource)

    }



    override fun getItemCount()= exampleList.size

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val imageView: ImageView = itemView.image_grid_view
        val textView: TextView = itemView.catalog_text

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = getAbsoluteAdapterPosition()
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }


    private fun getTextFromId(position: Int): String? {
        var catalog = "Sản phẩm"
        catalog = when (position) {
            0 -> "Gạo & mì các loại"
            1 -> "Thực phẩm đông lạnh"
            2 -> "Gia vị"
            3 -> "Rau, củ, quả"
            4 -> "Đồ khô & ăn vặt"
            5 -> "Thực phẩm đóng hộp"
            else -> ""
        }
        return catalog
    }
}