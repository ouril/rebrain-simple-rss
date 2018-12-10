package ru.rebrain.simple_rss.base.di.activity

import dagger.Component
import ru.rebrain.simple_rss.base.di.app.AppComponent
import ru.rebrain.simple_rss.main.MainActivity
import ru.rebrain.simple_rss.main.MainContract

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun mainPresenter(): MainContract.Presenter

    fun inject(mainActivity: MainActivity)
}