package com.example.mydemoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val exampleList = generateDummyList(6)
//        recycler_view
//        recycler_view.adapter = MainAdapter (exampleList)
//        recycler_view.layoutManager = GridLayoutManager(this, 2)
//        recycler_view.setHasFixedSize(true)
    }

//    private fun generateDummyList(size: Int): List<ExampleItem> {
//        val list = ArrayList<ExampleItem>()
//        for (i in 0 until size) {
//            val drawable = when (i % 6) {
//                0 -> R.drawable.bungao
//                1 -> R.drawable.donglanh
//                2 -> R.drawable.nuoccham
//                3 -> R.drawable.raucu
//                4 -> R.drawable.dokho
//                else -> R.drawable.dohop
//            }
//            val item = ExampleItem(drawable, "Item $i")
//            list += item
//        }
//        return list
//    }
}