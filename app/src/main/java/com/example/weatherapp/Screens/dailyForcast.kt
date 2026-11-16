package com.example.weatherapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.R


@Composable
fun dailyForcast(viewModel: MainViewModel = viewModel()){
    Column(modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        dailyForcast(viewModel)
    }
    // get a high quality image to display based on the PokeAPI character id.
//    val imageUrl = "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/${it.id.toString().padStart(4, '0')}.png"


    AsyncImage(
        model = "https://someimageurl.ca",
        contentDescription = "a description of image",
        modifier = Modifier.size(200.dp)
    )

}






@Composable//tring to change for the commit
fun DailyForcast(viewModel: MainViewModel) {//for the main menu and will change the days later when i have the API
    val hours = viewModel.weather?.temp


        Column( modifier = Modifier.fillMaxWidth()
            .verticalScroll(rememberScrollState())// so the user can scroll though out the days
        )
        {
            Text(""+ hours)
            HorizontalDivider()
        }


}

