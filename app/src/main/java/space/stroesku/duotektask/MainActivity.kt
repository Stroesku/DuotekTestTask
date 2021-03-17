package space.stroesku.duotektask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import space.stroesku.duotektask.viewmodel.MainViewModel



class MainActivity : AppCompatActivity() {
    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = ViewModelProvider(this).get(MainViewModel::class.java)
        App.appComponent.inject(model)
        initRecycler()
        }


    private fun initRecycler(){
        val adapter = RecyclerAdapter(model.getList().value!!)
        val manager = LinearLayoutManager(applicationContext)
        manager.orientation = LinearLayoutManager.VERTICAL
        recycleView.layoutManager = manager
        recycleView.adapter = adapter
    }
}