package space.stroesku.duotektask.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.stroesku.duotektask.database.Repository
import space.stroesku.duotektask.model.User
import javax.inject.Inject

class MainViewModel : ViewModel(){

    @Inject
    lateinit var repository: Repository
    val users: MutableLiveData<List<User>> = MutableLiveData()

    fun getUsers(){
        viewModelScope.launch {
            users.value = repository.dao.getUsers()
        }
    }

    fun loadDataToDatabase(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFromRemote()
        }
    }

    fun searchUser(searchQuery: String): LiveData<List<User>> {
    return repository.searchUser(searchQuery).asLiveData()
    }

}