package com.example.foodapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route=Screen.HomeScreen.route){
            HomeScreen(navController = navController)
        }
        composable(route=Screen.FoodScreen.route){
            FoodScreen(navController = navController)
        }
        composable(route = Screen.paymentScreen.route){
            paymentScreen(navController=navController)
        }
    }
}