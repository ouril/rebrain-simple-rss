package ru.rebrain.simple_rss.base.di.app

import android.app.Application
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.rebrain.simple_rss.base.di.network.NetworkModule
import ru.rebrain.simple_rss.base.di.network.RssService
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {

    fun app(): Application

    fun okHttpClient(): OkHttpClient

    fun retrofit(): Retrofit

    fun service(): RssService
}