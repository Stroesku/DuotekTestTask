package space.stroesku.duotektask.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_view.view.*
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.Photo
import space.stroesku.duotektask.ui.adapter.diff.PhotoListDiff

class PhotoListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val diffCallback = PhotoListDiff()
    private val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return PhotoListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.single_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PhotoListViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Photo>) {
        differ.submitList(list)
    }

    class PhotoListViewHolder
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.imageView

        fun bind(item: Photo) {
            Picasso.get().load(item.url).into(imageView)
            itemView.textView.text = item.title
        }
    }

}
