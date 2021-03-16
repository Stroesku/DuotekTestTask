package space.stroesku.duotektask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import space.stroesku.duotektask.repo.Repository
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)
        setContentView(R.layout.activity_main)
        val users = repository.getList()
        val adapter = RecyclerAdapter(users)
        val manager = LinearLayoutManager(applicationContext)
        manager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = manager
        recycleView.adapter = adapter


    }
    private fun initRecycler(){

    }
}