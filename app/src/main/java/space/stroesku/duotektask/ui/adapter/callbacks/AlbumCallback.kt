package space.stroesku.duotektask.ui.adapter.callbacks

import space.stroesku.duotektask.model.Album

interface AlbumCallback {
    fun onAlbumSelected(position: Int, item: Album)
}