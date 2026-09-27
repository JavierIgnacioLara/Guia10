package com.example.guia10.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.guia10.ui.screens.HomeScreen
import com.example.guia10.ui.screens.ProfileScreen
import com.example.guia10.ui.screens.SettingsScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val backStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry.value?.destination?.route

    Scaffold(
        bottomBar = {

            NavigationBar {

                NavigationBarItem(
                    selected = currentRoute == Screen.Inicio.route,
                    onClick = {
                        navController.navigate(Screen.Inicio.route)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Inicio"
                        )
                    },
                    label = {
                        Text("Inicio")
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == Screen.Perfil.route,
                    onClick = {
                        navController.navigate(Screen.Perfil.route)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil"
                        )
                    },
                    label = {
                        Text("Perfil")
                    }
                )

                NavigationBarItem(
                    selected = currentRoute == Screen.Ajustes.route,
                    onClick = {
                        navController.navigate(Screen.Ajustes.route)
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Ajustes"
                        )
                    },
                    label = {
                        Text("Ajustes")
                    }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Inicio.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Inicio.route) {
                HomeScreen()
            }

            composable(Screen.Perfil.route) {
                ProfileScreen()
            }

            composable(Screen.Ajustes.route) {
                SettingsScreen()
            }
        }
    }
}