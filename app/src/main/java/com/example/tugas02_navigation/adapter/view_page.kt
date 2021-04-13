package com.example.tugas02_navigation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.tugas02_navigation.fragment_tab1
import com.example.tugas02_navigation.fragment_tab2

class view_page (supportFragment: FragmentManager): FragmentPagerAdapter
    (supportFragment,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int):Fragment{
        return when (position){
            0-> fragment_tab1()
            else -> fragment_tab2()
        }
    }
    override fun getCount(): Int = 2
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Voice Call"
            else -> "video Call"
        }
    }
}