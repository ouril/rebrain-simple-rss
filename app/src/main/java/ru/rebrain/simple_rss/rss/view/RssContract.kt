package ru.rebrain.simple_rss.rss.view

import me.toptas.rssconverter.RssItem
import ru.rebrain.simple_rss.base.presenter.BasePresenterInterface
import ru.rebrain.simple_rss.base.view.AsyncCallbackView
import ru.rebrain.simple_rss.base.view.BaseViewInterface
import ru.rebrain.simple_rss.model.Feed

interface RssContract {

    interface Presenter : BasePresenterInterface<View> {
        fun loadRssItems(feed: Feed, fromCache: Boolean)
        fun browseRssUrl(rssItem: RssItem)
    }

    interface View : BaseViewInterface, AsyncCallbackView {
        fun onRssItemsLoaded(rssItems: List<RssItem>)
        fun onBrowse(rssItem: RssItem)
    }
}