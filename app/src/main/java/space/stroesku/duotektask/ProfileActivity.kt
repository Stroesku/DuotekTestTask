package space.stroesku.duotektask

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_profile)
        val user =  intent.getStringExtra("USER")
        Log.i("USER", user!!)
    }

}