package com.reynaldo.horoscopoapp.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.reynaldo.horoscapp.domain.model.HoroscopeModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.MutableState as MutableState1

@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition",
    "RememberReturnType"
)
@Composable
fun HorocopoDetail(horoscopoDetailViewModel: HoroscopoDetailViewModel) {

    val composableScope = rememberCoroutineScope()
    val context = LocalContext.current

    var patientName = remember { mutableStateOf("") }

    composableScope.launch {
        horoscopoDetailViewModel.getHoroscope(HoroscopeModel.Aries)
        horoscopoDetailViewModel.state.collect{
            when(it){
                is HoroscopeDetailState.Error -> errorState()
                HoroscopeDetailState.Loading -> loadingState()
                is HoroscopeDetailState.Success -> {
                    patientName =mutableStateOf( it.prediction)
                }
            }
        }

    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp)
        .background(Color.Red)){
        Column {
            Button(onClick = { /*TODO*/ }) {
                Text(text= "patientName.toString()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text= "patientName.toString()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text= "patientName.toString()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text= "patientName.toString()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text= patientName.toString())
            }
            Button(onClick = { /*TODO*/ }, Modifier.background(Color.DarkGray)) {
                Text(text= "patientName.toString()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text= "patientName.toString()")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text= "patientName.toString()")
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
