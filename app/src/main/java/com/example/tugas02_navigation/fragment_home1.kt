package com.example.tugas02_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.tugas02_navigation.adapter.view_page
import com.google.android.material.tabs.TabLayout

//

class fragment_home1 : Fragment() {
    private lateinit var pantek1 : ViewPager
    private lateinit var pantek2 : TabLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val pantek = inflater.inflate(R.layout.fragment_home1, container, false)
        pantek1 = pantek.findViewById(R.id.viewpager)
        pantek2 = pantek.findViewById(R.id.tablayout)
        val btnn = view_page(childFragmentManager)
        pantek1.adapter = btnn
        pantek2.setupWithViewPager(pantek1)
        return pantek
    }
    companion object {
    }
}