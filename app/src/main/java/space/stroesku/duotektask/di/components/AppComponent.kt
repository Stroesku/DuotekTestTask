package space.stroesku.duotektask.di.components

import dagger.Component
import space.stroesku.duotektask.MainActivity
import space.stroesku.duotektask.di.modules.RepoModule
import space.stroesku.duotektask.viewmodel.MainViewModel
import javax.inject.Singleton

@Component(modules = [
    RepoModule::class
    ]
)

@Singleton
interface AppComponent {
 fun inject(mainViewModel:MainViewModel)

}