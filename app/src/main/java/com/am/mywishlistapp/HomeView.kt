package com.am.mywishlistapp

import androidx.compose.ui.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.am.mywishlistapp.data.Wish

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.am.mywishlistapp.data.DummyWish


@Composable
fun HomeView( navController: NavController,
              viewModel: WishViewModel){
    val context = LocalContext.current
    Scaffold(
        topBar = { AppBarView(title =  "WishList", {
            Toast.makeText(context, "ButtonClicked", Toast.LENGTH_LONG).show()
        })},
        floatingActionButton = {

            FloatingActionButton (
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.White,
                containerColor = Color.Black,
                onClick = {
                    //TODO Add navigation to add screen
                    Toast.makeText(context, "FAButtonClicked", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.AddScreen.route)
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items (DummyWish.wishList) {
                wish -> WishItem(wish = wish) {

            }
            }
        }
    }
}

@Composable
fun WishItem(wish: Wish, onClick:() -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable { onClick()},
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ){
        Column(modifier = Modifier
            .padding(16.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.Bold)
            Text(text = wish.description)
        }
    }
}