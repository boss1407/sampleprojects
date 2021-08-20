package com.example.challenge.data

import com.example.challenge.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v3/search/anime")
    suspend fun getShows(@Query("q") searchName:String): Response<APIResponse>
}