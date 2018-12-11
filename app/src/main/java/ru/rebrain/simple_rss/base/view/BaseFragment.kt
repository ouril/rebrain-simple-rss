package ru.rebrain.simple_rss.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import ru.rebrain.simple_rss.App
import ru.rebrain.simple_rss.base.di.activity.ActivityComponent
import ru.rebrain.simple_rss.base.di.activity.ActivityModule
import ru.rebrain.simple_rss.base.di.activity.DaggerActivityComponent

abstract class BaseFragment : Fragment(), BaseViewInterface, AsyncCallbackView {

    @get:LayoutRes
    protected abstract val layoutResource: Int

    abstract fun inject(component: ActivityComponent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inject(
            DaggerActivityComponent.builder()
                .appComponent(App.component())
                .activityModule(ActivityModule())
                .build())

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResource, container, false)
    }
}