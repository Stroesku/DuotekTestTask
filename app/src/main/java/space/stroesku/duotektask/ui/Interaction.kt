package space.stroesku.duotektask.ui

import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo

interface Interaction {
    fun onItemSelected(position: Int, item: Album)
}