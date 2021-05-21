package space.stroesku.duotektask.di.components

import dagger.Component
import space.stroesku.duotektask.di.modules.RepoModule
import space.stroesku.duotektask.viewmodel.MainViewModel
import space.stroesku.duotektask.viewmodel.PhotoListViewModel
import space.stroesku.duotektask.viewmodel.ProfileViewModel
import javax.inject.Singleton

@Component(modules = [
    RepoModule::class
    ]
)

@Singleton
interface AppComponent {
 fun inject(mainViewModel: MainViewModel)
 fun inject(profileViewModel: ProfileViewModel)
 fun inject(photoListViewModel: PhotoListViewModel)
}