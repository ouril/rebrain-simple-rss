package ru.rebrain.simple_rss.main

import android.os.Bundle
import ru.rebrain.simple_rss.R
import ru.rebrain.simple_rss.base.di.activity.ActivityComponent
import ru.rebrain.simple_rss.base.view.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override val layoutResId = R.layout.activity_main

    override fun inject(component: ActivityComponent) {
        component.inject(this)
    }

    override fun init(state: Bundle?) {
        presenter.attach(this)
        presenter.loadHelloText()

        /*hello_tv.setOnClickListener {
            presenter.loadHelloText()
        }*/
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    override fun onTextLoaded(text: String) {
        //hello_tv.text = text
    }
}