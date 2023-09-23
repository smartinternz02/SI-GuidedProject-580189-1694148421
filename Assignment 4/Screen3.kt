package com.example.foodapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color


data class Food(val name: String, val image: Int)

val menu = listOf(
    Food("Hybedabadi Dum Biriyani", R.drawable.chickenbiryani),
    Food("Boti kebab", R.drawable.kebab),
    Food("Double ka Meetha", R.drawable.doublekameetha),
    Food("Haleem", R.drawable.haleem)
)

@ExperimentalMaterial3Api
@Composable
fun FoodList(navController: NavController) {
    LazyColumn {
        items(menu.size) { index ->
            val food = menu[index]
            MenuItem(food = food, navController = navController)
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun MenuItem(food: Food, navController: NavController) {


    Card(
        modifier = Modifier
            .fillMaxWidth()
//            .absolutePadding(left = 20.dp, right = 20.dp, top =)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        onClick = { navController.navigate(Screen.paymentScreen.route) },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = food.image),
                contentDescription = food.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,


                )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = food.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun FoodScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray)) {
        FoodList(navController)
    }}



