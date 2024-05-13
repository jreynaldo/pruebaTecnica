package com.reynaldo.horoscopoapp.domain

import com.reynaldo.horoscapp.domain.model.PrediccionModel

interface Repository {
    suspend fun getPrediction(sign: String):PrediccionModel?
}