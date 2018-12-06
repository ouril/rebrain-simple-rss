package ru.rebrain.simple_rss.base.presenter

import ru.rebrain.simple_rss.base.view.BaseViewInterface

open class BasePresenter<V : BaseViewInterface> : BasePresenterInterface<V> {

    var view: V? = null

    override val isAttached = view != null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}