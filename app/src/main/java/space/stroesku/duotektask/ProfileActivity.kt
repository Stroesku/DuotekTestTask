package space.stroesku.duotektask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.user_profile.*
import space.stroesku.duotektask.model.data.repo.Repository
import space.stroesku.duotektask.model.data.users.Address
import space.stroesku.duotektask.model.data.users.Company
import space.stroesku.duotektask.model.data.users.Geo
import space.stroesku.duotektask.model.data.users.User
import space.stroesku.duotektask.viewmodel.main.MainViewModel
import space.stroesku.duotektask.viewmodel.profile.ProfileViewModel

class ProfileActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ProfileViewModel::class.java)
    }

    lateinit var user:User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)
        App.appComponent.inject(viewModel)

        viewModel.currentAlbums.observe(this){
                val list = it
                if(list.isNotEmpty()){
                    println(list[0])
                }
        }
        createUser()




    }

    fun createUser(){
        val id = intent.getIntExtra("id",0)
        val name = intent.getStringExtra("name")
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val website = intent.getStringExtra("website")
        val address = Address("MSK","Chertanovo","sd","535435", Geo("d","s"))
        val company = Company("MSK","Chertanovo","sd")
        _idTV.text = id.toString()
        _nameTV.text = name
        _userNameTV.text = username
        _emailTV.text = email
        _phoneTV.text = phone
        _websiteTV.text = website
        _cityTV.text = address.city
        _suiteTV.text = address.suite
        _streetTV.text = address.street
        _zipcodeTV.text = address.zipcode
        _latTV.text = address.geo.lat
        _lngTV.text = address.geo.lng
        _companyName.text = company.name
        _companyDescription.text = company.catchPhrase
        _bsTV.text = company.bs

        viewModel.loadAlbums()
        viewModel.loadAlbumsById(id)
        user = User(id, name, username, email, address,phone,website,company)
    }

}