package ru.rebrain.simple_rss.main

import ru.rebrain.simple_rss.base.presenter.BasePresenterInterface
import ru.rebrain.simple_rss.base.view.BaseViewInterface
import ru.rebrain.simple_rss.model.Feed

interface MainContract {

    interface Presenter : BasePresenterInterface<View> {
        fun loadRssFragments()

    }

    interface View : BaseViewInterface {
        fun onLoadRssFragments(feeds: List<Feed>)
    }
}