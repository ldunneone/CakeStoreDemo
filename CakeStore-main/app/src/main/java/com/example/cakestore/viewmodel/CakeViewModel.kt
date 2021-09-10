package com.example.cakestore.viewmodel


import android.app.Activity
import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cakestore.databinding.ActivityMainBinding
import com.example.cakestore.models.JsonAPIItem
import com.example.cakestore.repository.CakeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
 class CakeViewModel @Inject constructor(
    private val repository: CakeRepository
    ): ViewModel() {
   lateinit var binding: ActivityMainBinding

    private val _response = MutableLiveData<List<JsonAPIItem>>()
    val responseCake: LiveData<List<JsonAPIItem>>
        get() = _response
    init {
        getAllCakes()
    }
     fun getAllCakes() = viewModelScope.launch {
        repository.getCake().let {response ->
            if(response.isSuccessful){
                _response.postValue(response.body())
            }else{
                Log.d("CAKES","getAllCakes error: ${response.code()}")
            }

        }
    }

}