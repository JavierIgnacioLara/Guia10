package com.example.guia10.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.guia10.ui.screens.HomeScreen
import com.example.guia10.ui.screens.ProfileScreen
import com.example.guia10.ui.screens.SettingsScreen
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val backStackEntry =
        navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry.value?.destination?.route

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet {

                Text(
                    text = "Guia 10",
                    modifier = Modifier.padding(
                        horizontal = 24.dp,
                        vertical = 24.dp
                    )
                )

                NavigationDrawerItem(
                    label = {
                        Text("Inicio")
                    },
                    selected = currentRoute == Screen.Inicio.route,
                    onClick = {
                        navController.navigate(Screen.Inicio.route)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Inicio"
                        )
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text("Perfil")
                    },
                    selected = currentRoute == Screen.Perfil.route,
                    onClick = {
                        navController.navigate(Screen.Perfil.route)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Perfil"
                        )
                    }
                )

                NavigationDrawerItem(
                    label = {
                        Text("Ajustes")
                    },
                    selected = currentRoute == Screen.Ajustes.route,
                    onClick = {
                        navController.navigate(Screen.Ajustes.route)
                        scope.launch {
                            drawerState.close()
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Ajustes"
                        )
                    }
                )
            }
        }
    ) {

        Scaffold(

            topBar = {

                TopAppBar(
                    title = {
                        Text(
                            when (currentRoute) {
                                Screen.Perfil.route -> "Perfil"
                                Screen.Ajustes.route -> "Ajustes"
                                else -> "Inicio"
                            }
                        )
                    },
                    navigationIcon = {

                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {

                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Abrir menú"
                            )
                        }
                    }
                )
            },

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
                modifier = androidx.compose.ui.Modifier.padding(innerPadding)
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
}