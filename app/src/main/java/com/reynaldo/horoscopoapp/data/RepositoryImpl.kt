package com.reynaldo.horoscopoapp.data

import android.util.Log

import com.reynaldo.horoscapp.domain.model.PrediccionModel
import com.reynaldo.horoscopoapp.data.network.HoroscopeApiService
import com.reynaldo.horoscopoapp.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PrediccionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Reynaldo", "Ha ocurrido un error ${it.message}") }
        return null
    }
}