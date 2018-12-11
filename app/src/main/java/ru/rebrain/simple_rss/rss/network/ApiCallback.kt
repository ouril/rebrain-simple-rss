package ru.rebrain.simple_rss.rss.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.rebrain.simple_rss.model.RssError

abstract class ApiCallback<T> : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.code() == 200 && response.body() != null) {
            onSuccess(response.body()!!)
        } else {
            onFail(RssError.generic())
        }
    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        onFail(RssError.network())
    }

    abstract fun onSuccess(response: T)

    open fun onFail(rssError: RssError) {

    }
}