package space.stroesku.duotektask.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_item.view.*
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.ui.Interaction


class AlbumsAdapter(private val interaction: Interaction) :
    RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    private val diffCallback = AlbumsItemDiff()
    private val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.album_item, parent, false),
            interaction
        )
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Album>) {
        differ.submitList(list)
    }

    class AlbumViewHolder(itemView: View, private val interaction: Interaction?) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(albumItem: Album) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, albumItem)
            }
            itemView.album_name.text = albumItem.title
        }
    }

}