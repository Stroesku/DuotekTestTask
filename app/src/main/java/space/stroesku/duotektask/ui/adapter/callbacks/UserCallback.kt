package space.stroesku.duotektask.ui.adapter.callbacks

import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.User

interface UserCallback {
    fun onUserSelected(position: Int, item: User)

}
