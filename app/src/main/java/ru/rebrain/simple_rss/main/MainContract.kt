package ru.rebrain.simple_rss.main

import ru.rebrain.simple_rss.base.presenter.BasePresenterInterface
import ru.rebrain.simple_rss.base.view.BaseViewInterface

interface MainContract {

    interface Presenter : BasePresenterInterface<MainContract.View> {
        fun loadHelloText()
    }

    interface View : BaseViewInterface {
        fun onTextLoaded(text: String)
    }
}