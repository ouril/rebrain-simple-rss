package ru.rebrain.simple_rss.base.view

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import ru.rebrain.simple_rss.App
import ru.rebrain.simple_rss.R
import ru.rebrain.simple_rss.base.di.activity.ActivityComponent
import ru.rebrain.simple_rss.base.di.activity.ActivityModule
import ru.rebrain.simple_rss.base.di.activity.DaggerActivityComponent
import ru.rebrain.simple_rss.model.RssError

abstract class BaseActivity : AppCompatActivity(), BaseViewInterface {

    @get:LayoutRes
    protected abstract val layoutResId: Int

    protected abstract fun inject(component: ActivityComponent)

    protected abstract fun init(state: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        inject(
            DaggerActivityComponent.builder()
                .appComponent(App.component())
                .activityModule(ActivityModule())
                .build()
        )
        init(savedInstanceState)
    }

    override fun onFail(error: RssError) {
        error.message = when (error.code) {
            RssError.ERROR_GENERIC -> {
                getString(R.string.err_rss_no_item)
            }
            RssError.ERROR_NETWORK -> {
                getString(R.string.err_network)
            }
            else -> getString(R.string.err_rss_no_item)

        }

        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

}