package ru.rebrain.simple_rss.base.di.activity

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ru.rebrain.simple_rss.base.di.network.RssService
import ru.rebrain.simple_rss.main.MainContract
import ru.rebrain.simple_rss.main.MainPresenter

@Module
class ActivityModule(private val activity: FragmentActivity) {

    @Provides
    @ActivityScope
    fun provideMainPresenter(service: RssService): MainContract.Presenter = MainPresenter(service)
}