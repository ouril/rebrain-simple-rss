package ru.rebrain.simple_rss.rss.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RssFragmentAdapter(fm: FragmentManager,
                         private val rssFragments: ArrayList<RssFragment>,
                         private val titles: ArrayList<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return rssFragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }

    override fun getCount(): Int {
        return rssFragments.size
    }
}