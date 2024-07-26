package com.example.mansbestfriend

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor


class PetViewModel (application: Application):AndroidViewModel(application) {

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val apIservise = Retrofit.Builder()
        .baseUrl("https//dog.ceo/api/breed")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(APIservise::class.java)

    
    private val repository = PetRpository(apIservise)

    private val _petList = MutableStateFlow<List<Breed>>(emptyList())
    val PetList: StateFlow<List<Breed>> = _petList

    init {
        getPet()
    }

    private fun getPet() = viewModelScope.launch {
        _petList.value = repository.GetBreed()
    }

    init {
        fetchPet()
    }

    fun fetchPet() = viewModelScope.launch {
        val petList = repository.GetBreed()
        _petList.value = petList
    }

    fun getCharacter(pet_id:String) = viewModelScope.launch {
        val _details = repository.getBreedDetails(pet_id)
        _petList.value = _details
    }

    fun SearchCharacter(pet_name:String) = viewModelScope.launch {
        val petList = repository.SearchBreedName(pet_name)
        _petList.value = petList
    }


}