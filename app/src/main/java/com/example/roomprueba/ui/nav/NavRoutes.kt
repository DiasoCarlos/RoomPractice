package com.example.roomprueba.ui.nav

sealed class NavRoutes(val route : String) {

    object Home:NavRoutes("Home")
    object Test:NavRoutes("Test/{nombre}/{apellido}/{monto}/{telefono}"){
        fun createParametersRoute(nombre: String, apellido:String, monto:String, telefono:String) :String{
            return "Test/$nombre/$apellido/$monto/$telefono"
        }
    }

    object Login:NavRoutes("Login")

    object SignUp:NavRoutes("SignUp")

}