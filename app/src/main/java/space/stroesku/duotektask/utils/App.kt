package space.stroesku.duotektask.utils

import android.app.Application
import space.stroesku.duotektask.di.modules.RepoModule
import space.stroesku.duotektask.di.components.AppComponent
import space.stroesku.duotektask.di.components.DaggerAppComponent

class App : Application() {

    companion object {
        /**
         * Component that have dependencies graph
         */
        lateinit var appComponent: AppComponent
            private set

        lateinit var appContext: Application
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .repoModule(RepoModule())
            .build()
        appContext = applicationContext as Application
    }
}