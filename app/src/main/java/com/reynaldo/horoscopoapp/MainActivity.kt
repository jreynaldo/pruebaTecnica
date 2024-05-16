package com.reynaldo.horoscopoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.reynaldo.horoscopoapp.ui.HoroscopeViewModel
import com.reynaldo.horoscopoapp.ui.ListaSignosSodicacoScreen
import com.reynaldo.horoscopoapp.ui.detail.HorocopoDetail
import com.reynaldo.horoscopoapp.ui.detail.HoroscopoDetailViewModel
import com.reynaldo.horoscopoapp.ui.theme.BlackAlpha
import com.reynaldo.horoscopoapp.ui.theme.Secondary
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val horoscopeViewModel: HoroscopeViewModel = hiltViewModel()
            val horoscopoDetailViewModel: HoroscopoDetailViewModel = hiltViewModel()

            Scaffold(topBar = {
                ToolTopBar()
            },
                bottomBar = { ToolBottomBar() }
            ) { innerPadding ->
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.listaSignos,
                    builder = {
                        composable(Routes.listaSignos) {
                            ListaSignosSodicacoScreen(
                                navController,
                                innerPadding,
                                horoscopeViewModel.horoscope.value
                            )
                        }
                        composable(Routes.horoscopoDetalle) {
                            val signo = it.arguments?.getString("signo")?:""
                            HorocopoDetail(horoscopoDetailViewModel,signo)
                        }
                    })
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ToolTopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Horoscopo App") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = BlackAlpha,
            titleContentColor = Secondary,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ToolBottomBar() {
    BottomAppBar(
        contentColor = Secondary,
        containerColor = BlackAlpha,

        ) {
        Spacer(modifier = Modifier.weight(1f, true))

        IconButton(onClick = { /* do something */ }) {
            Icon(
                painterResource(id = R.drawable.ic_horoscope),
                contentDescription = "Horosocopo"
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { /* do something */ }) {
            Icon(
                painterResource(id = R.drawable.ic_cards),
                contentDescription = "Cards"
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
        IconButton(onClick = { /* do something */ }) {
            Icon(
                painterResource(id = R.drawable.ic_hand),
                contentDescription = "Hands"
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
    }

}


