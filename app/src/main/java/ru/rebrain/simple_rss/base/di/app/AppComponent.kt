package ru.rebrain.simple_rss.base.di.app

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun app(): Application
}