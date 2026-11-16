package com.example.weatherapp

import android.annotation.SuppressLint
import android.app.Application
import android.location.Location
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import  androidx.lifecycle.viewModelScope
import com.example.weatherapp.Data.DAO.Weather
import com.example.weatherapp.Data.InterFace
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

class MainViewModel(app: Application) : AndroidViewModel(app){
    //provider
    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(app)
    var location by mutableStateOf<Location?>(null)// NOTE: import Android's built-in Location class  android.location.Location
        private set
    var weather by mutableStateOf<Weather?>(null)

    private val api = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.co/") // API hostname
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(InterFace::class.java) // Interface

fun Getweather(query:String) {// query is the lating
    // Launch co-routine
    viewModelScope.launch {
        weather = api.Weather(q=query)

    }
}
    @SuppressLint("MissingPermission") // silence warning
    fun refreshLocation() {
        fusedLocationClient
            .getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
            .addOnSuccessListener { result ->
                location = result
                val latlng = "${location?.latitude},${location?.longitude}"
                Getweather(latlng)
            }

    }

}

