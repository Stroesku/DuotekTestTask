package space.stroesku.duotektask.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_photo_list.*
import space.stroesku.duotektask.R
import space.stroesku.duotektask.model.User
import space.stroesku.duotektask.ui.adapter.callbacks.UserCallback
import space.stroesku.duotektask.ui.adapter.UserListAdapter
import space.stroesku.duotektask.utils.App
import space.stroesku.duotektask.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(), UserCallback, SearchView.OnQueryTextListener {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var userListAdapter: UserListAdapter

    val viewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(viewModel)
        mRecyclerView = recycler_users
        initRecycler()
        viewModel.getUsers()
        viewModel.loadDataToDatabase()
        viewModel.users.observe(this, Observer { response ->
            userListAdapter.submitList(response)
        })

    }

    private fun initRecycler() {
        userListAdapter = UserListAdapter(this)
        mRecyclerView.apply {
            adapter = userListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        userListAdapter.submitList(listOf())
    }

    override fun onUserSelected(position: Int, item: User) {
        val intent = Intent(this, ProfileActivity()::class.java)
        intent.putExtra("user", item)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val search = menu?.findItem(R.id.menu_search)
        val searchView = search?.actionView as? SearchView
        searchView?.isSubmitButtonEnabled = true
        searchView?.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "$query%"
        viewModel.searchUser(searchQuery).observe(this, Observer { list ->
            list.let {
                userListAdapter.submitList(it)
            }
        })
    }

}









