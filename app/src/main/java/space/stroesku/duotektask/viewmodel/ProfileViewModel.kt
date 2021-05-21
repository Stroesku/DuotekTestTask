package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo
import space.stroesku.duotektask.model.data.repo.Repository
import javax.inject.Inject

class ProfileViewModel : ViewModel() {

    @Inject
    lateinit var repository: Repository
    private val _currentAlbums: MutableLiveData<List<Album>> = MutableLiveData()
    val currentAlbums: LiveData<List<Album>> = _currentAlbums
    var albums: List<Album> = emptyList()


    fun loadAlbums() {
        viewModelScope.launch {
            albums = repository.getAlbums()
            _currentAlbums.value = albums
        }
    }


    fun loadAlbumsById(id: Int) {
        _currentAlbums.value = albums.filter { it.userId == id }
    }


}