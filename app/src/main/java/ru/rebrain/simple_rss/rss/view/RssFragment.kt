package ru.rebrain.simple_rss.rss.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_rss.*
import me.toptas.rssconverter.RssItem
import ru.rebrain.simple_rss.R
import ru.rebrain.simple_rss.base.di.activity.ActivityComponent
import ru.rebrain.simple_rss.base.view.BaseFragment
import ru.rebrain.simple_rss.model.Feed
import ru.rebrain.simple_rss.model.RssError
import javax.inject.Inject


class RssFragment :
    BaseFragment(), RssContract.View, SwipeRefreshLayout.OnRefreshListener, RssItemsAdapter.OnItemClickListener {

    @Inject
    lateinit var presenter: RssContract.Presenter

    private lateinit var feed: Feed
    private lateinit var adapter: RssItemsAdapter
    private var listener: OnItemSelectListener? = null


    override val layoutResource = R.layout.fragment_rss

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feed = arguments!!.getSerializable(KEY_FEED) as Feed
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        adapter = RssItemsAdapter(this)

        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = adapter
        swr.setOnRefreshListener(this)
        presenter.loadRssItems(feed, true)
    }

    override fun onRssItemsLoaded(rssItems: List<RssItem>) {
        adapter.setItems(rssItems)
        empty_state_tv.visibility = View.GONE
        recycler_view.visibility = View.VISIBLE
    }

    override fun onBrowse(rssItem: RssItem) {
        listener?.onItemSelected(rssItem)
    }

    override fun onItemSelected(rssItem: RssItem) {
        presenter.browseRssUrl(rssItem)
    }

    override fun onRefresh() {
        presenter.loadRssItems(feed, false)
    }

    override fun showLoading() {
        if (isAdded) swr.isRefreshing = true
    }

    override fun hideLoading() {
        if (isAdded) swr.isRefreshing = false
    }

    override fun onFail(error: RssError) {
        empty_state_tv.visibility = View.VISIBLE
        recycler_view.visibility = View.GONE
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnItemSelectListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        private const val KEY_FEED = "key_feed"

        fun newInstance(feed: Feed): RssFragment {
            val rssFragment = RssFragment()
            val bundle = Bundle()
            bundle.putSerializable(KEY_FEED, feed)
            rssFragment.arguments = bundle
            return rssFragment
        }
    }

    interface OnItemSelectListener {
        fun onItemSelected(rssItem: RssItem)
    }
}