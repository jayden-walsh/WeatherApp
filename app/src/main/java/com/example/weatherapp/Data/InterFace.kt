package com.example.weatherapp.Data

import androidx.compose.ui.graphics.vector.Path
import com.example.weatherapp.Data.DAO.Weather
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface InterFace {
    @GET("https://api.weatherapi.com/v1/current.json?key=60e1924a56244df685c180256261910&q=halifax+nova+scotia&aqi=no")
    suspend fun Weather(
        @Query("Key") key: String = "60e1924a56244df685c180256261910",
        @Query("q") q: String,
        @Query("days") days: String = "3",
        @Query("aqi") aqi: String = "no",
        @Query("alert") alert: String = "no",




        ): Weather
}