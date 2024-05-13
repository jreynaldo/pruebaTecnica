package com.reynaldo.horoscopoapp.domain.usecase


import com.reynaldo.horoscopoapp.domain.Repository
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sing: String) = repository.getPrediction(sing)

}