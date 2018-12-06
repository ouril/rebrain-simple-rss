package ru.rebrain.simple_rss.base.presenter

import ru.rebrain.simple_rss.base.view.BaseViewInterface

interface BasePresenterInterface<V : BaseViewInterface> {

    val isAttached: Boolean

    fun attach(view: V)

    fun detach()
}