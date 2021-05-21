package space.stroesku.duotektask.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_profile.*
import space.stroesku.duotektask.ui.adapter.AlbumsAdapter
import space.stroesku.duotektask.App
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.data.albums.Album
import space.stroesku.duotektask.model.data.albums.photos.Photo
import space.stroesku.duotektask.model.data.users.User
import space.stroesku.duotektask.ui.Interaction
import space.stroesku.duotektask.viewmodel.ProfileViewModel

class ProfileActivity : AppCompatActivity(), Interaction {
    companion object {
        private const val TAG = "ProfileActivity"
    }

    private lateinit var albumRecycler: RecyclerView
    lateinit var albumAdapter: AlbumsAdapter

    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProfileViewModel::class.java)
    }

    lateinit var user: User
    var albums = listOf<Album>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)
        App.appComponent.inject(viewModel)

        initRecycler()

        //get list album from remote
        viewModel.currentAlbums.observe(this) { album ->
            albumAdapter.submitList(album.filter { it.userId == user.id })
        }
        getDataFromIntent()

        viewModel.loadAlbums()
        viewModel.loadAlbumsById(user.id)

    }

    //TODO сделать получение данных через Parcelable или Serializable
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
            albumAdapter = AlbumsAdapter(this@ProfileActivity)
            adapter = albumAdapter
        }
        albumAdapter.submitList(albums)

    }

    override fun onItemSelected(position: Int, item: Album) {
        Toast.makeText(this, "click to ${item.title}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, PhotoListActivity::class.java)
        intent.putExtra("album", item)
        startActivity(intent)
    }

}