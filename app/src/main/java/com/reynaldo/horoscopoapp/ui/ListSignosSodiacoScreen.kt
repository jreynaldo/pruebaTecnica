package com.reynaldo.horoscopoapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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



        ListaSignos(navController,innerPadding,listaSignos)
}


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ListaSignos(
    navController: NavHostController,
    innerPadding: PaddingValues,
    listaSignos: List<HoroscopeInfo>
) {

    Box(
        Modifier
            .background(Primary)
            .padding(innerPadding)
            .fillMaxSize()){


    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth(),

        ) {

            Column(verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxHeight()) {
                RecipeCard(navController,listaSignos.get(0))
                RecipeCard(navController, listaSignos.get(2))
                RecipeCard(navController, listaSignos.get(4))
                RecipeCard(navController, listaSignos.get(6))
                RecipeCard(navController, listaSignos.get(8))
                RecipeCard(navController, listaSignos.get(10))
            }
        Column(verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxHeight()) {
                RecipeCard(navController, listaSignos.get(1))
                RecipeCard(navController, listaSignos.get(3))
                RecipeCard(navController, listaSignos.get(5))
                RecipeCard(navController, listaSignos.get(7))
                RecipeCard(navController, listaSignos.get(9))
                RecipeCard(navController, listaSignos.get(11))
            }

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
            .clickable { navController.navigate("horoscopo_detail")}) {
            Image(painter = painterResource(id = horoscopeInfo.img),
                contentDescription = "imagen"
            )
            Text(text = stringResource(id = horoscopeInfo.name))
        }
    }
}