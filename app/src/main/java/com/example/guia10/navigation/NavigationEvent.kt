package com.example.guia10.navigation

sealed class NavigationEvent{

    data object IrAInicio : NavigationEvent()

    data object IrAPerfil : NavigationEvent()

    data object IrAAjustes : NavigationEvent()

    data object Volver : NavigationEvent()

}