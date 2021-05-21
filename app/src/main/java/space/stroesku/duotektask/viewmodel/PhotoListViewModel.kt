package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import space.stroesku.duotektask.model.data.albums.photos.Photo
import space.stroesku.duotektask.model.data.repo.Repository
import javax.inject.Inject

class PhotoListViewModel : ViewModel() {
    @Inject
    lateinit var repository: Repository
    private val _currentPhotos: MutableLiveData<List<Photo>> = MutableLiveData()
    val currentPhoto: LiveData<List<Photo>> = _currentPhotos
    var photos: List<Photo> = emptyList()

    fun loadPhotos() {
        viewModelScope.launch {
            photos = repository.getPhotos()
            _currentPhotos.value = photos
        }
    }

    fun loadPhotosById(id: Int) {
        _currentPhotos.value = photos.filter { it.id == id }
    }
}