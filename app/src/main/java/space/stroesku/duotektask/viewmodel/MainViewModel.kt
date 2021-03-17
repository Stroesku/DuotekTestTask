package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.stroesku.duotektask.repo.Repository
import javax.inject.Inject

class MainViewModel : ViewModel(){
    @Inject
    lateinit var repository: Repository
    lateinit var data: MutableLiveData<MutableList<User>>

     fun getList():MutableLiveData<MutableList<User>>{
         data = repository.getLiveList()
        return data
    }
}