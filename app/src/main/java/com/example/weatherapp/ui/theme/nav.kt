package com.example.weatherapp.ui.theme


import android.R
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import  androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.ShortNavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun nav(){
    Scaffold(
        modifier = Modifier,
        topBar = {
        TopAppBar(
            colors  = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor =  MaterialTheme.colorScheme.primary,),
            title = {
                Text("Top app")
            }
        )
        }
    ) { innerPadding  ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("hello")
        }
         }}
//    Scaffold(bottomBar = {
//        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
//
//        }
//    }) { NavigationBarItem(icon ={ Icon(imageVector = Icon.Default.Search, contentDescription = "search") },) { } }
//}


// default set to 0
    // (topBar = {
