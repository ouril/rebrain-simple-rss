package ru.rebrain.simple_rss.rss.network

import me.toptas.rssconverter.RssItem
import ru.rebrain.simple_rss.model.RssError

data class RssResponse(val success: List<RssItem>? = null, val rssError: RssError? = null) {

    companion object {
        fun success(data: List<RssItem>?): RssResponse = RssResponse(data, null)

        fun error(rssError: RssError) = RssResponse(null, rssError)
    }
}