package ru.rebrain.simple_rss.main

import android.content.Context
import com.google.gson.Gson
import ru.rebrain.simple_rss.model.Feed
import ru.rebrain.simple_rss.utils.Utils
import java.util.*

class MainRepositoryImpl(private val context: Context) : MainRepository {

    override fun parseFeeds(): List<Feed> {
        val jsonString = Utils.readFromAssets(context, MainRepositoryImpl.RSS_FILE)
        val gson = Gson()
        val feeds = gson.fromJson(jsonString, Array<Feed>::class.java)
        return Arrays.asList(*feeds)
    }

    companion object {
        private const val RSS_FILE = "rss.json"
    }

}

interface MainRepository {
    fun parseFeeds(): List<Feed>
}