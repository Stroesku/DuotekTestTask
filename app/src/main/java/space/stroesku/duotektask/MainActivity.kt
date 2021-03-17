package space.stroesku.duotektask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject
import space.stroesku.duotektask.model.Users
import space.stroesku.duotektask.model.UserDataItem
import space.stroesku.duotektask.repo.Repository
import space.stroesku.duotektask.viewmodel.MainViewModel
import space.stroesku.duotektask.viewmodel.MainViewModelFactory
//import space.stroesku.duotektask.viewmodel.MainViewModel
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: Repository
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val viewModelFactory = MainViewModelFactory()
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            App.appComponent.inject(viewModel)
            viewModel.getUsers()
            viewModel.myResponse.observe(this, Observer { response ->
                val list = response
                Log.d("Response", list.toString())
            })


            //initRecycler()
            // Instance of users list using the data model class.

        }
//    private fun initRecycler() {
//        // Adapter class is initialized and list is passed in the param.
//        val adapter = RecyclerAdapter(usersList, this)
//        // Set the LayoutManager that this RecyclerView will use.
//        val manager = LinearLayoutManager(applicationContext)
//        manager.orientation = LinearLayoutManager.VERTICAL
//        recycleView.layoutManager = manager
//        // adapter instance is set to the recyclerview to inflate the items.
//        recycleView.adapter = adapter
//    }









//    private fun getData() {
//        var content = StringBuilder()
//        try {
//            // As we have JSON object, so we are getting the object
//            //Here we are calling a Method which is returning the JSON object
//            val myUrl = URL("http://jsonplaceholder.typicode.com/users")  // or URL to txt file
//            val urlConnection = myUrl.openConnection() as HttpURLConnection
//            val inputStream = urlConnection.inputStream
//            val allText = inputStream.bufferedReader().use { it.readText() }
//            content.append(allText)
//            val str = content.toString()
//
//
//            Log.i("JSON", str)
//            val obj = JSONObject(getJSONFromAssets()!!)
//
//            // fetch JSONArray named users by using getJSONArray
//            val usersArray = obj.getJSONArray("users")
//            // Get the users data using for loop i.e. id, name, email and so on
//
//            for (i in 0 until usersArray.length()) {
//                // Create a JSONObject for fetching single User's Data
//                val user = usersArray.getJSONObject(i)
//                // Fetch id store it in variable
//                val id = user.getInt("id")
//                val name = user.getString("name")
//                val username = user.getString("username")
//                val email = user.getString("email")
//                val website = user.getString("website")
//                val phone = user.getString("phone")
//                val address = user.getJSONObject("address")
//                val street = address.getString("street")
//                val suite = address.getString("suite")
//                val city = address.getString("city")
//                val zipcode = address.getString("zipcode")
//                val geo = address.getJSONObject("geo")
//                val lat = geo.getString("lat")
//                val lng = geo.getString("lng")
//                val company = user.getJSONObject("company")
//                val compName = company.getString("name")
//                val catchPhrase = company.getString("catchPhrase")
//                val bs = company.getString("bs")
//
//                // Now add all the variables to the data model class and the data model class to the array list.
//                val userDetails =
//                        Users(id, name, username, email, phone, website, street, suite, city,
//                                zipcode, lat, lng, compName, catchPhrase, bs)
//                // add the details in the list
//                usersList.add(userDetails)
//            }
//        } catch (e: JSONException) {
//            //exception
//            e.printStackTrace()
//        }
//    }

//    /**
//     * Method to load the JSON from the Assets file and return the object
//     */
//    private fun getJSONFromAssets(): String? {
//        var json: String? = null
//        val charset: Charset = Charsets.UTF_8
//        try {
//            val myUsersJSONFile = assets.open("users.json")
//            val size = myUsersJSONFile.available()
//            val buffer = ByteArray(size)
//            myUsersJSONFile.read(buffer)
//            myUsersJSONFile.close()
//            json = String(buffer, charset)
//        } catch (ex: IOException) {
//            ex.printStackTrace()
//            return null
//        }
//        return json
//    }
}








