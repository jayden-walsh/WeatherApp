package com.example.weatherapp.ui


import android.Manifest
import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import  androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.MainViewModel
import com.example.weatherapp.Screens.CurrentForcaste
import com.example.weatherapp.Screens.CurrentForcaste
import com.example.weatherapp.Screens.DailyForcast
import com.example.weatherapp.Screens.DailyForcast


fun refreshLocation() {

}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)


@Composable
fun navT() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0)}
        val viewModel: MainViewModel = viewModel()


        // Begin: Ask permission to get device location.
        // Note: If permission is previously granted, the dialog won't appear and refreshLocation() will get called.
        val launcher = rememberLauncherForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { results ->
            if (results.values.any { it }) {
                viewModel.refreshLocation() // call a function to get the current location for device
            }
        }

        LaunchedEffect(Unit) {
            launcher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            )
        }
        // End: Ask permission to get device location.} // default set to 0// default set to 0


    // For The Top Bar
        Scaffold(
            modifier = Modifier,
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),

                    title = { val WeatherLocation = viewModel.weather?.location?.toString() ?: "Location"
                        Text(WeatherLocation)

                    }
                )
            },
            //For Switching The Menus
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
                            navController.navigate(route = "currentForcast") {
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
                        label = { Text("daily  Forcast") },
                        selected = selectedIndex == 1,
                        onClick = {
                            selectedIndex = 1
                            navController.navigate(route = "dailyForcast") {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        )
        { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "currentForcast",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = "currentForcast") {
                    CurrentForcaste(viewModel)
                }
                composable(route = "dailyForcast") {
                    DailyForcast(viewModel)
                }

            }
        }
    }















// default set to 0
    // (topBar = {
