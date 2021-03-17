package space.stroesku.duotektask

import android.app.Application
import space.stroesku.duotektask.di.modules.RepoModule
import space.stroesku.duotektask.di.components.AppComponent
import space.stroesku.duotektask.di.components.DaggerAppComponent
import javax.inject.Inject

class App : Application() {
//    @Inject
//    lateinit var appComponent: AppComponent
    

    companion object {
        /**
         * Component that have dependencies graph
         */
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
             appComponent = DaggerAppComponent.builder()
            .repoModule(RepoModule())
            .build()
    }
}