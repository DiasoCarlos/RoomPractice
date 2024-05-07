package com.example.roomprueba.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.roomprueba.ui.HomeScreen
import com.example.roomprueba.ui.TestScren

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {

        composable(
            route = NavRoutes.Home.route
        ){

            HomeScreen(
                navigateToText = { nombre, apellido, monto, telefono ->
                    navController.navigate(
                        NavRoutes.Test.createParametersRoute(nombre,apellido, monto, telefono)
                    )
                }
            )

        }

        composable(
            route = NavRoutes.Test.route,
            arguments = listOf(
                navArgument("nombre"){type = NavType.StringType},
                navArgument("apellido"){type = NavType.StringType},
                navArgument("monto"){type = NavType.StringType},
                navArgument("telefono"){type = NavType.StringType}
            )
        ){

            TestScren(
                nombre = it.arguments?.getString("nombre") ?: "",
                apellido = it.arguments?.getString("apellido") ?: "",
                monto = it.arguments?.getString("monto") ?: "",
                telefono = it.arguments?.getString("telefono") ?: ""
            )

        }

    }


}