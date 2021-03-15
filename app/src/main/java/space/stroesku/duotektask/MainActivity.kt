package space.stroesku.duotektask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import space.stroesku.duotektask.repo.Repository


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }
    private fun initRecycler(){
        val repository = Repository()
        val users = repository.getList()
        val adapter = RecyclerAdapter(users)
        val manager = LinearLayoutManager(applicationContext)
        manager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = manager
        recycleView.adapter = adapter
    }
}