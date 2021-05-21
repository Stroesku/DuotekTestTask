package space.stroesku.duotektask.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import kotlinx.android.synthetic.main.user_item_new.view.*
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.User
import space.stroesku.duotektask.ui.adapter.callbacks.UserCallback
import space.stroesku.duotektask.ui.adapter.diff.UserListDiff


class UserListAdapter(private val interaction: UserCallback? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val diffCallback = UserListDiff()
    private val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return UserListHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.user_item_new,
                parent,
                false
            ),
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserListHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<User>) {
        differ.submitList(list)
    }

    class UserListHolder
    constructor(
        itemView: View,
        private val userCallback: UserCallback?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: User) {
            itemView.setOnClickListener{
                userCallback?.onUserSelected(adapterPosition, item)
            }
            itemView.user_name.text = item.name
            itemView.user_email.text = item.email
            itemView.user_number.text = item.phone
        }
    }
}
