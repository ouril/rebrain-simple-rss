package ru.rebrain.simple_rss.main

import ru.rebrain.simple_rss.base.presenter.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val repository: MainRepository) :
    BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun loadRssFragments() {
        view?.onLoadRssFragments(repository.parseFeeds())
    }
}