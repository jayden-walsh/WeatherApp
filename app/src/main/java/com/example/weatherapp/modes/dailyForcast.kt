package com.example.weatherapp.modes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateBounds
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.images
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.example.weatherapp.ui.theme.nav_T





@Composable
fun dailyForcast(){
    Column(modifier = Modifier.fillMaxSize().padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        days_menu()
    }

}




@Composable
fun monday(

){ Column(modifier = Modifier.fillMaxSize().padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,{
        Image(
            painter = painterResource(id = R.drawable.sun),
            contentDescription = "sun",
            modifier = Modifier.size(120.dp)
        )
        Text("it feels like 5")
    })
}


@Composable
fun tuesday(
){
    Column(modifier = Modifier.fillMaxSize().padding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,{
            Image(
                painter = painterResource(id = R.drawable.sun),
                contentDescription = "sun",
                modifier = Modifier.size(120.dp)
            )
            Text("it feels like 7")
        })
}


@Composable
fun days_menu() {
    var days by remember { mutableIntStateOf(0) }
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column( modifier = Modifier.fillMaxSize()
            .padding()
        )
            {
                monday()
                HorizontalDivider()
                tuesday()
                HorizontalDivider()

            }


}
        }
