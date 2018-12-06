package ru.rebrain.simple_rss.main

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.rebrain.simple_rss.R
import ru.rebrain.simple_rss.base.view.BaseActivity

class MainActivity : BaseActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter

    override val layoutResId = R.layout.activity_main

    override fun init(state: Bundle?) {
        presenter = MainPresenter()
        presenter.attach(this)
        presenter.loadHelloText()

        hello_tv.setOnClickListener {
            presenter.loadHelloText()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun onTextLoaded(text: String) {
        hello_tv.text = text
    }
}