package ru.rebrain.simple_rss.base.view

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import ru.rebrain.simple_rss.App
import ru.rebrain.simple_rss.base.di.activity.ActivityComponent
import ru.rebrain.simple_rss.base.di.activity.ActivityModule
import ru.rebrain.simple_rss.base.di.activity.DaggerActivityComponent

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
                .activityModule(ActivityModule(this))
                .build()
        )
        init(savedInstanceState)
    }
}