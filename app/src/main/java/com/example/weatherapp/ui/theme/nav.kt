package com.example.weatherapp.ui.theme


import android.R
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import  androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.ShortNavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.espresso.base.Default
import com.example.weatherapp.MainActivity
import com.example.weatherapp.images
import com.example.weatherapp.modes.dailyForcast
import kotlinx.coroutines.selects.select


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun nav_T() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) } // default set to 0// default set to 0
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Chicago")
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }

            Scaffold(
                modifier = Modifier,
            bottomBar = {
                NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.WbSunny,
                                contentDescription = "search"
                            )
                        },
                        label = { Text("current Forcast") },
                        selected = selectedIndex == 0,
                        onClick = {
                            selectedIndex = 0
                            navController.navigate(route = "current forcast") {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Cloud,
                                contentDescription = "dailyforcast"
                            )
                        },
                        label = { Text("daily  forcast") },
                        selected = selectedIndex == 1,
                        onClick = {
                            selectedIndex = 0
                            navController.navigate(route = "current forcast") {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true


                            }
                        })
                }
            }
            )
            { innerPadding ->
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                    images()
                    Text("feels like 43.")
                    NavHost(
                    navController = navController,
                    startDestination = "daily Forcast",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable(route = "current Forcast") {
                        MainActivity()
                    }
                    composable(route = "daily forcast") {
                        dailyForcast()
                    }

                }
                }}}}












// default set to 0
    // (topBar = {
