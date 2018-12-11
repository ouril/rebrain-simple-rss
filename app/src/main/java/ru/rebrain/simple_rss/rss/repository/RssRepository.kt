package ru.rebrain.simple_rss.rss.repository

import me.toptas.rssconverter.RssFeed
import ru.rebrain.simple_rss.model.RssError
import ru.rebrain.simple_rss.rss.network.ApiCallback
import ru.rebrain.simple_rss.rss.network.RssResponse
import ru.rebrain.simple_rss.rss.network.RssService
import javax.inject.Inject

class RssRepositoryImpl @Inject constructor(private val service: RssService) :
    RssRepository {

    override fun fetchRss(url: String, listener: RssResponseListener) {
        service.getRss(url).enqueue(object : ApiCallback<RssFeed>() {
            override fun onSuccess(response: RssFeed) {
                listener.getResponse(url, RssResponse.success(response.items))
            }

            override fun onFail(error: RssError) {
                listener.getResponse(url, RssResponse.error(error))
            }
        })
    }
}

interface RssRepository {
    fun fetchRss(url: String, listener: RssResponseListener)
}