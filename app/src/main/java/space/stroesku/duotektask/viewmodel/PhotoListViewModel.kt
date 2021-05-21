package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import space.stroesku.duotektask.model.Photo
import space.stroesku.duotektask.database.Repository
import javax.inject.Inject

class PhotoListViewModel : ViewModel() {

    @Inject
    lateinit var repository: Repository
    private val _currentPhotos: MutableLiveData<List<Photo>> = MutableLiveData()
    val currentPhoto: LiveData<List<Photo>> = _currentPhotos
    var photos: List<Photo> = emptyList()

    fun loadPhotos(albumId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            photos = repository.dao.getPhotoOfAlbum(albumId)
            _currentPhotos.postValue(photos)
        }
    }
}
