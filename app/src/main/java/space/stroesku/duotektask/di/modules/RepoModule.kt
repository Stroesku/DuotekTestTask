package space.stroesku.duotektask.di.modules

import dagger.Module
import dagger.Provides
import space.stroesku.duotektask.model.data.repo.Repository
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun provideRepository():Repository{
        return Repository()
    }
}