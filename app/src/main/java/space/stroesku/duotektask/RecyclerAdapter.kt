package space.stroesku.duotektask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.ArrayList


    class RecyclerAdapter(private val users: MutableList<UserModel>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

        inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val layout: RelativeLayout = view.findViewById(R.id.parentRelative)
            val userFirstName: TextView = view.findViewById<View>(R.id.userFirstName) as TextView
            val userLastName: TextView = view.findViewById<View>(R.id.userLastName) as TextView
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_item, parent, false)
            return MyViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val userItem = users[position]
            holder.userFirstName.text = userItem.fName
            holder.userLastName.text = userItem.lName
            holder.layout.setOnClickListener {
                Log.i("TAG","click to$userItem")
            }
        }


        override fun getItemCount(): Int {
            return users.size
        }
    }
