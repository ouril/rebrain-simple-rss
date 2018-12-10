package ru.rebrain.simple_rss

import android.app.Application
import ru.rebrain.simple_rss.base.di.app.AppComponent
import ru.rebrain.simple_rss.base.di.app.AppModule
import ru.rebrain.simple_rss.base.di.app.DaggerAppComponent

class App : Application() {

    companion object {
        private var appComponent: AppComponent? = null

        fun component(): AppComponent {
            return appComponent!!
        }

        fun setComponent(component: AppComponent) {
            appComponent = component
        }
    }

    override fun onCreate() {
        super.onCreate()
        setComponent(
            DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        )
    }
}