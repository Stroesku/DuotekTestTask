package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.stroesku.duotektask.database.Dao
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.database.Repository
import javax.inject.Inject

class ProfileViewModel : ViewModel() {

    @Inject
    lateinit var repository: Repository
    private val _currentAlbums: MutableLiveData<List<Album>> = MutableLiveData()
    val currentAlbums: LiveData<List<Album>> = _currentAlbums
    private var albums: List<Album> = emptyList()


    fun loadAlbums(userId:Int) {
        viewModelScope.launch {
            albums = repository.dao.getAlbumsOfUser(userId)
            _currentAlbums.value = albums
        }
    }
}