package ru.rebrain.simple_rss.base.di.activity

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.rebrain.simple_rss.main.MainContract
import ru.rebrain.simple_rss.main.MainPresenter
import ru.rebrain.simple_rss.main.MainRepository
import ru.rebrain.simple_rss.main.MainRepositoryImpl
import ru.rebrain.simple_rss.rss.network.RssService
import ru.rebrain.simple_rss.rss.repository.RssRepository
import ru.rebrain.simple_rss.rss.repository.RssRepositoryImpl
import ru.rebrain.simple_rss.rss.view.RssContract
import ru.rebrain.simple_rss.rss.view.RssPresenter

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    fun provideMainPresenter(repository: MainRepository): MainContract.Presenter = MainPresenter(repository)

    @Provides
    @ActivityScope
    fun provideMainRepository(app: Application): MainRepository = MainRepositoryImpl(app)

    @Provides
    @ActivityScope
    fun provideRssRepository(service: RssService): RssRepository =
        RssRepositoryImpl(service)

    @Provides
    @ActivityScope
    fun provideRssPresenter(repository: RssRepository): RssContract.Presenter = RssPresenter(repository)
}