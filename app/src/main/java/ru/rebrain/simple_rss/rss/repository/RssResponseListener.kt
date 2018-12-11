package ru.rebrain.simple_rss.rss.repository

import ru.rebrain.simple_rss.rss.network.RssResponse

interface RssResponseListener {
    fun getResponse(url: String, response: RssResponse)
}