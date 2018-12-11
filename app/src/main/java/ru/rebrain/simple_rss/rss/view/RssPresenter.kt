package ru.rebrain.simple_rss.rss.view

import me.toptas.rssconverter.RssItem
import ru.rebrain.simple_rss.base.presenter.BasePresenter
import ru.rebrain.simple_rss.model.Feed
import ru.rebrain.simple_rss.rss.network.RssResponse
import ru.rebrain.simple_rss.rss.repository.RssRepository
import ru.rebrain.simple_rss.rss.repository.RssResponseListener
import javax.inject.Inject

class RssPresenter @Inject constructor(
    private val repository: RssRepository
) :
    BasePresenter<RssContract.View>(), RssContract.Presenter, RssResponseListener {


    override fun loadRssItems(feed: Feed, fromCache: Boolean) {
        view?.showLoading()
        repository.fetchRss(feed.url, this)
    }

    override fun browseRssUrl(rssItem: RssItem) {
        view?.onBrowse(rssItem)
    }


    override fun getResponse(url: String, response: RssResponse) {
        response.success?.apply {
            if (isNotEmpty()) {
                view?.onRssItemsLoaded(this)
            }
        }

        response.rssError?.apply {
            view?.onFail(this)
        }

        view?.hideLoading()
    }

}