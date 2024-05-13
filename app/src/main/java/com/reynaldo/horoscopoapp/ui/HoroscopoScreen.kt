package com.reynaldo.horoscopoapp.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun HoroscopoScreen(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination = "ListaSignosSodicacoScreen" , ){}
}



