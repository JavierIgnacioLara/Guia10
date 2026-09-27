package com.example.guia10.viewmodel

import androidx.lifecycle.ViewModel
import com.example.guia10.navigation.NavigationEvent
import com.example.guia10.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _currentScreen = MutableStateFlow<Screen>(Screen.Inicio)
    val currentScreen: StateFlow<Screen> = _currentScreen.asStateFlow()

    fun onNavigationEvent(event: NavigationEvent) {

        when (event) {

            NavigationEvent.IrAInicio -> {
                _currentScreen.value = Screen.Inicio
            }

            NavigationEvent.IrAPerfil -> {
                _currentScreen.value = Screen.Perfil
            }

            NavigationEvent.IrAAjustes -> {
                _currentScreen.value = Screen.Ajustes
            }

            NavigationEvent.Volver -> {
                _currentScreen.value = Screen.Inicio
            }
        }
    }
}

