package com.example.viewpager.activities

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager.R
import com.example.viewpager.ViewPagerAdapter
import com.example.viewpager.fragments.BikeFragment
import com.example.viewpager.fragments.CarFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val carFragment = CarFragment()
        val bikeFragment = BikeFragment()

        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(carFragment, "Car")
        adapter.addFragment(bikeFragment, "Bike")

        viewPager.adapter = adapter
        viewPager.currentItem = 0
        viewPager.offscreenPageLimit = 2

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTabTitle(position)
        }.attach()
    }
}
