package space.stroesku.duotektask.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import space.stroesku.duotektask.model.data.albums.Album

class AlbumsItemDiff : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}