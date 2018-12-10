package ru.rebrain.simple_rss.main

import ru.rebrain.simple_rss.base.di.network.RssService
import ru.rebrain.simple_rss.base.presenter.BasePresenter
import java.util.*
import javax.inject.Inject

class MainPresenter @Inject constructor(val service: RssService) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    private val helloTexts = listOf("BONJOUR", "HOLA", "HALLO", "MERHABA", "HELLO", "CIAO", "KONNICHIWA")

    override fun loadHelloText() {
        val random = Random()
        val hello = helloTexts[random.nextInt(helloTexts.size)]
        view?.onTextLoaded(hello)
    }
}