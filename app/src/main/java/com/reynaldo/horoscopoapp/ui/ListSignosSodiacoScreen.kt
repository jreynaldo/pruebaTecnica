package com.reynaldo.horoscopoapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.reynaldo.horoscapp.domain.model.HoroscopeInfo
import com.reynaldo.horoscopoapp.ui.theme.Primary
import com.reynaldo.horoscopoapp.ui.theme.Secondary


@Composable
fun ListaSignosSodicacoScreen(
    navController: NavHostController,
    innerPadding: PaddingValues,
    listaSignos: List<HoroscopeInfo>
) {
    ListaSignos(navController, innerPadding, listaSignos)
}


@SuppressLint("StateFlowValueCalledInComposition")

@Composable
fun ListaSignos(
    navController: NavHostController,
    innerPadding: PaddingValues,
    listaSignos: List<HoroscopeInfo>
) {

    LazyVerticalGrid(

       columns= GridCells.Fixed(3),
        verticalArrangement=Arrangement.Center,
        horizontalArrangement = Arrangement.Absolute.Center,
        modifier = Modifier.fillMaxSize().background(Primary)


    ) {


        items(listaSignos)
        {
            RecipeCard(navController, it)
        }

    }
}

@Composable
fun RecipeCard(navController: NavHostController, horoscopeInfo: HoroscopeInfo) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(4.dp),
        color = Primary,
        contentColor = Secondary
    ) {
        Column(modifier = Modifier
            .padding(4.dp)
            .clickable { navController.navigate("horoscopo_detail/${horoscopeInfo.index}") }) {
            Image(
                painter = painterResource(id = horoscopeInfo.img),
                contentDescription = "imagen"
            )
            Text(text = stringResource(id = horoscopeInfo.name))
        }
    }
}