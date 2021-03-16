package space.stroesku.duotektask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import space.stroesku.duotektask.User

class MainViewModel : ViewModel(){
    lateinit var mUser: MutableLiveData<MutableList<User>>
    private val mIsUpdating = MutableLiveData<Boolean>()



}