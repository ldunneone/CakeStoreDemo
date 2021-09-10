package com.example.cakestore.api

import com.example.cakestore.helper.Constants
import com.example.cakestore.models.CakeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.End_Point)
    suspend fun getCakes():Response<CakeResponse>
}