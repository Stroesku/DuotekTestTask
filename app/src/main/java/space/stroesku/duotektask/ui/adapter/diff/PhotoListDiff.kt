package space.stroesku.duotektask.ui.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import space.stroesku.duotektask.model.Photo

class PhotoListDiff : DiffUtil.ItemCallback<Photo>() {

    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}