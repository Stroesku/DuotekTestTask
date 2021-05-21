package space.stroesku.duotektask.ui.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import space.stroesku.duotektask.model.User


class UserListDiff : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
