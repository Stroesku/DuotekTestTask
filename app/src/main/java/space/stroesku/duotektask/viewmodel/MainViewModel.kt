package space.stroesku.duotektask.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.stroesku.duotektask.App
import space.stroesku.duotektask.User
import space.stroesku.duotektask.repo.Repository
import javax.inject.Inject

class MainViewModel : ViewModel(){
    @Inject
    lateinit var repository: Repository



     fun getList():MutableLiveData<MutableList<User>>{
        return repository.getLiveList()
    }

}