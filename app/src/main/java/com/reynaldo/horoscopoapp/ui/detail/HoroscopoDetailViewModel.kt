package com.reynaldo.horoscopoapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reynaldo.horoscapp.domain.model.HoroscopeModel
import com.reynaldo.horoscopoapp.domain.usecase.GetPrediction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HoroscopoDetailViewModel @Inject constructor(private val getPrediction: GetPrediction): ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state:StateFlow<HoroscopeDetailState> = _state
    lateinit var horoscopeModel: HoroscopeModel
    fun getHoroscope(sign: HoroscopeModel){
        horoscopeModel = sign
        viewModelScope.launch() {
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO){getPrediction(sign.name)}
            if (result != null){
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign, horoscopeModel)
            }
            else{
                _state.value = HoroscopeDetailState.Error("A ocurrido un error ")
            }
        }
    }
}