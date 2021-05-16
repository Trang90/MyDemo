package com.example.mydemoapplication

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), MainAdapter.OnItemClickListener {
    private val exampleList = generateDummyList(6)

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)

    }


    override fun onItemClick(position: Int) {
        //Toast.makeText(activity, "Item $position clicked", Toast.LENGTH_SHORT).show()
        view?.findNavController()?.navigate(R.id.action_mainFragment_to_catalogFragment)

    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 0 until size) {
            val drawable = when (i % 6) {
                0 -> R.drawable.bungao
                1 -> R.drawable.donglanh
                2 -> R.drawable.nuoccham
                3 -> R.drawable.raucu
                4 -> R.drawable.dokho
                else -> R.drawable.dohop
            }
            val item = ExampleItem(drawable, "Item $i")
            list += item
        }
        return list}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        recycler_view_main.adapter = MainAdapter (exampleList, this)
        recycler_view_main.layoutManager = GridLayoutManager(getActivity(), 2)
        recycler_view_main.setHasFixedSize(true)
    }

}