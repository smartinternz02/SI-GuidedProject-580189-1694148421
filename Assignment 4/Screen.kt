package com.example.foodapp

sealed class Screen(val route:String){
    object LoginScreen: Screen("loginScreen")
    object HomeScreen:Screen("home")
    object FoodScreen:Screen("foodScreen")
    object paymentScreen:Screen("paymentScreen")
}

