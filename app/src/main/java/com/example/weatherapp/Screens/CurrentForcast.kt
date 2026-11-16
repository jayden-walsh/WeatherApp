package com.example.weatherapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R

@Composable // for the home screen and today
fun CurrentForcaste(viewModel: MainViewModel) {
    LaunchedEffect(Unit) {
        viewModel.Getweather("Wellington")
    }

    val weather = viewModel.weather

    Column(
        verticalArrangement = Arrangement.spacedBy(43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (weather != null) {
            val weatherText = "$weather"

            if (weatherText.contains("rain")) {
                Text(
                    text = "Today is rainy ($weatherText)",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.rain),
                    contentDescription = "Rain",
                    modifier = Modifier.size(120.dp)
                )
            } else {
                Text(
                    text = "Today is $weatherText",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                //to change the icons
                Image(
                    painter = painterResource(id = R.drawable.rain),
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(120.dp)
                )
            }
        } else {
            Text(
                text = "Loading  weather...",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    }
}
