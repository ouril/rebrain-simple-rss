package ru.rebrain.simple_rss.base.view

import ru.rebrain.simple_rss.model.RssError

interface BaseViewInterface {
    fun onFail(error: RssError)
}