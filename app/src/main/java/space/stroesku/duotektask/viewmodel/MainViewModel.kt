package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import space.stroesku.duotektask.model.Users
import space.stroesku.duotektask.repo.Repository

import javax.inject.Inject

class MainViewModel : ViewModel(){
    @Inject
    lateinit var repository: Repository
    val myResponse: MutableLiveData<Response<List<Users>>> = MutableLiveData()

    fun getUsers(){
        viewModelScope.launch {
            val response = repository.getUsers()
            myResponse.value = response
        }
    }
}