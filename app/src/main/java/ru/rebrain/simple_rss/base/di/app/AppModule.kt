package ru.rebrain.simple_rss.base.di.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val app: Application
) {

    @Provides
    @Singleton
    internal fun provideApplication() = app
}