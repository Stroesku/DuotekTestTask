package space.stroesku.duotektask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_photo_list.*
import space.stroesku.duotektask.App
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo
import space.stroesku.duotektask.ui.adapter.PhotoListAdapter
import space.stroesku.duotektask.viewmodel.PhotoListViewModel

class PhotoListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "PhotoListActivity"
    }

    var photos = listOf<Photo>()
    private lateinit var mRecyclerView: RecyclerView
    lateinit var photoAdapter: PhotoListAdapter
    val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(PhotoListViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(viewModel)
        setContentView(R.layout.activity_photo_list)
        mRecyclerView = recycler_photo
        initRecycler()
        val album = intent.extras?.getSerializable("album") as Album
        viewModel.currentPhoto.observe(this) { list ->
            photoAdapter.submitList(list.filter { it.albumId == album.id })
            Log.e(TAG, "onCreate: ${photos.size}")
        }

        viewModel.loadPhotos()
        viewModel.loadPhotosById(album.id)

        Log.i(TAG, "onCreate: ${album.title}")
    }

    private fun initRecycler() {
        mRecyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
            photoAdapter = PhotoListAdapter()
            adapter = photoAdapter
            setHasFixedSize(true)
        }
        photoAdapter.submitList(listOf())
    }
}