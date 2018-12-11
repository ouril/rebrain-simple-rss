package ru.rebrain.simple_rss.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import ru.rebrain.simple_rss.R
import ru.rebrain.simple_rss.base.di.activity.ActivityComponent
import ru.rebrain.simple_rss.base.view.BaseActivity
import ru.rebrain.simple_rss.model.Feed
import ru.rebrain.simple_rss.rss.view.RssFragment
import ru.rebrain.simple_rss.rss.view.RssFragmentAdapter
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override val layoutResId = R.layout.activity_main

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }

    override fun init(state: Bundle?) {
        setSupportActionBar(toolbar)
        tab_layout.setupWithViewPager(view_pager)
        tab_layout.tabMode = TabLayout.MODE_SCROLLABLE

        presenter.attach(this)
        presenter.loadRssFragments()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun onLoadRssFragments(feeds: List<Feed>) {
        val fragmentList = ArrayList<RssFragment>()
        val titles = ArrayList<String>()
        for (feed in feeds) {
            fragmentList.add(RssFragment.newInstance(feed))
            titles.add(feed.title)
        }

        val adapter = RssFragmentAdapter(supportFragmentManager, fragmentList, titles)
        view_pager.adapter = adapter
    }
}