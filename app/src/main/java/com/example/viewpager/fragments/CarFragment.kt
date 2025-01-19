package com.example.viewpager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpager.R

class CarFragment : Fragment() {

    val itemList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_car, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList.add(0, "Mercury")
        itemList.add(1, "Venus")
        itemList.add(2, "Earth")
        itemList.add(3, "Mars")
        itemList.add(4, "Jupiter")

        val listView = view.findViewById<ListView>(R.id.list_view)
        view.findViewById<TextView>(R.id.textview_car)

        val adapter: ArrayAdapter<String>? = activity?.let {
            ArrayAdapter<String>(
                it,
                android.R.layout.simple_list_item_1,
                itemList
            )
        }
        listView.adapter = adapter

    }
}
