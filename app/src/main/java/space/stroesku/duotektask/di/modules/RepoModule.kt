package space.stroesku.duotektask.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import space.stroesku.duotektask.repo.Repository
import javax.inject.Singleton

@Module
class RepoModule {
    @Singleton
    @Provides
    fun provideRepository():Repository{
        return Repository()
    }
}