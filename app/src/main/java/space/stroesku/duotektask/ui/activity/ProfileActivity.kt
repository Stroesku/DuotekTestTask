package space.stroesku.duotektask.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_profile.*
import space.stroesku.duotektask.ui.adapter.AlbumListAdapter
import space.stroesku.duotektask.utils.App
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.Album
import space.stroesku.duotektask.model.User
import space.stroesku.duotektask.ui.adapter.callbacks.AlbumCallback
import space.stroesku.duotektask.viewmodel.ProfileViewModel

class ProfileActivity : AppCompatActivity(), AlbumCallback {


    private lateinit var albumRecycler: RecyclerView
    private lateinit var albumAdapter: AlbumListAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProfileViewModel::class.java)
    }

    lateinit var user: User
    private var albums = listOf<Album>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)
        App.appComponent.inject(viewModel)
        initRecycler()

        viewModel.currentAlbums.observe(this) { list ->
            albumAdapter.submitList(list)
        }
        getDataFromIntent()
        viewModel.loadAlbums(user.id)
    }


    private fun getDataFromIntent() {
        user = intent.extras?.getSerializable("user") as User
        setDataToActivity(user)
    }


    private fun setDataToActivity(user: User) {
        _idTV.text = user.id.toString()
        _nameTV.text = user.name
        _userNameTV.text = user.username
        _emailTV.text = user.email
        _phoneTV.text = user.phone
        _websiteTV.text = user.website
        _cityTV.text = user.address.city
        _suiteTV.text = user.address.suite
        _streetTV.text = user.address.street
        _zipcodeTV.text = user.address.zipcode
        _latTV.text = user.address.geo.lat
        _lngTV.text = user.address.geo.lng
        _companyName.text = user.company.name
        _companyDescription.text = user.company.catchPhrase
        _bsTV.text = user.company.bs
    }

    private fun initRecycler() {
        albumRecycler = recycler_album
        albumRecycler.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity)
            albumAdapter = AlbumListAdapter(this@ProfileActivity)
            adapter = albumAdapter
        }
        albumAdapter.submitList(albums)

    }

    override fun onAlbumSelected(position: Int, item: Album) {
        val intent = Intent(this, PhotoListActivity::class.java)
        intent.putExtra("album", item)
        startActivity(intent)
    }

}