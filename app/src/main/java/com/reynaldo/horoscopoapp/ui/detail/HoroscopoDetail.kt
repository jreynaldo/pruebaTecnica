package com.reynaldo.horoscopoapp.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reynaldo.horoscapp.domain.model.HoroscopeModel
import com.reynaldo.horoscopoapp.R
import com.reynaldo.horoscopoapp.ui.theme.Primary
import com.reynaldo.horoscopoapp.ui.theme.Secondary
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.compose.runtime.MutableState as MutableState1

@SuppressLint(
    "StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition",
    "RememberReturnType"
)
@Composable
fun HorocopoDetail(horoscopoDetailViewModel: HoroscopoDetailViewModel, signo: String) {


    var patientName by remember {
        mutableStateOf(
            HoroscopeDetailState.Success(
                "",
                "",
                HoroscopeModel.Aries
            )
        )
    }
    val horoscopeModel = HoroscopeModel?.fromIndex(signo.toInt()) ?: HoroscopeModel.Aries

    LaunchedEffect(Unit) {
        horoscopoDetailViewModel.getHoroscope(horoscopeModel)
        horoscopoDetailViewModel.state.collectLatest {
            when (it) {
                is HoroscopeDetailState.Error -> errorState()
                HoroscopeDetailState.Loading -> loadingState()
                is HoroscopeDetailState.Success -> {
                    patientName = it
                }
            }
        }

    }
    Box(
        modifier = Modifier
            .background(Primary)
            .padding(20.dp)
            .fillMaxSize()


    ) {
        if (patientName.prediction.equals("")) {
            CircularProgressIndicator(modifier = Modifier.fillMaxSize())
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {
                item {


                    var image = when (patientName.horoscopeModel) {
                        HoroscopeModel.Aries -> R.drawable.detail_aries
                        HoroscopeModel.Taurus -> R.drawable.detail_taurus
                        HoroscopeModel.Gemini -> R.drawable.detail_gemini
                        HoroscopeModel.Cancer -> R.drawable.detail_cancer
                        HoroscopeModel.Leo -> R.drawable.detail_leo
                        HoroscopeModel.Virgo -> R.drawable.detail_virgo
                        HoroscopeModel.Libra -> R.drawable.detail_libra
                        HoroscopeModel.Scorpio -> R.drawable.detail_sagittarius
                        HoroscopeModel.Sagittarius -> R.drawable.detail_scorpio
                        HoroscopeModel.Capricorn -> R.drawable.detail_cancer
                        HoroscopeModel.Aquarius -> R.drawable.detail_aquarius
                        HoroscopeModel.Pisces -> R.drawable.detail_pisces

                    }

                    Image(
                        painter = painterResource(id = image),
                        contentDescription = "imagen"
                    )
                    Text(text = patientName.sign, fontSize = 30.sp, color = Secondary)
                    Text(
                        text = patientName.prediction,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize(),
                        fontSize = 24.sp,
                        color = Secondary,
                    )

                }

            }
        }

    }


}

fun successState(context: Context, it: HoroscopeDetailState.Success) {
    Toast.makeText(context, it.prediction, Toast.LENGTH_SHORT).show()
}


fun loadingState() {
    print("Cargando")
}

fun errorState() {
    TODO("Not yet implemented")
}
