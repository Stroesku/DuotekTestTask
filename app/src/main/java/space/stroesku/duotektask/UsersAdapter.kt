package space.stroesku.duotektask
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import space.stroesku.duotektask.model.data.users.User


class UsersAdapter(private val users: MutableList<User>?,
                   private val context:Context) : RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {
    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val layout: RelativeLayout = view.findViewById(R.id.parentRelative)
            val id: TextView = view.findViewById<View>(R.id.userID) as TextView
            val name: TextView = view.findViewById<View>(R.id.userName) as TextView
            val phone: TextView = view.findViewById<View>(R.id.userPhone) as TextView

        }
    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(context)
                .inflate(R.layout.user_item, parent, false)
            return MyViewHolder(itemView)
        }
    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val userItem = users?.get(position)
        if (userItem != null) {
            holder.id.text = "${userItem.id}."
            holder.name.text = userItem.name
            holder.phone.text = userItem.phone
        }
            holder.layout.setOnClickListener {
                val contextRV =holder.layout.context
                val intent = Intent(contextRV, ProfileActivity()::class.java).apply {
                    putExtra("id", userItem?.id)
                    putExtra("name", userItem?.name)
                    putExtra("username", userItem?.username)
                    putExtra("email", userItem?.email)
                    putExtra("phone", userItem?.phone)
                    putExtra("website", userItem?.website)
                }
                contextRV.startActivity(intent)
            }

        }

    /**
     * Gets the number of items in the list
     */
        override fun getItemCount(): Int {
            return users!!.size
        }
    }
