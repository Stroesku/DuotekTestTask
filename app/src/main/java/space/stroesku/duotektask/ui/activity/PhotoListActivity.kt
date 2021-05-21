package space.stroesku.duotektask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_photo_list.*
import space.stroesku.duotektask.utils.App
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.ui.adapter.PhotoListAdapter
import space.stroesku.duotektask.viewmodel.PhotoListViewModel

class PhotoListActivity : AppCompatActivity() {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var photoAdapter: PhotoListAdapter

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
            photoAdapter.submitList(list)
        }
        viewModel.loadPhotos(album.id)
    }

    private fun initRecycler() {
        mRecyclerView.apply {
            layoutManager =
                GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
            photoAdapter = PhotoListAdapter()
            adapter = photoAdapter
            setHasFixedSize(true)
        }
        photoAdapter.submitList(listOf())
    }
}