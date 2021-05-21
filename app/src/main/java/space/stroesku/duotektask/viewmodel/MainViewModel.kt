package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.stroesku.duotektask.model.data.users.User
import space.stroesku.duotektask.model.data.repo.Repository
import javax.inject.Inject

class MainViewModel : ViewModel(){
    @Inject
    lateinit var repository: Repository
    val myResponse: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers(){
        viewModelScope.launch {
            val response = repository.getUsers()
            myResponse.value = response
        }
    }
}