package com.example.cakestore.repository

import com.example.cakestore.api.ApiService
import javax.inject.Inject

class CakeRepository  @Inject constructor(private val apiService: ApiService){
    suspend fun getCake() = apiService.getCakes()
}