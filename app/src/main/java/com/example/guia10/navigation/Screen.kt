package com.example.guia10.navigation

sealed class  Screen(val route: String){

    data object Inicio: Screen("inicio")
    data object Perfil: Screen("perfil")
    data object Ajustes: Screen("ajustes")

}

