package com.example.challenge.data.helper

import com.example.challenge.model.APIResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getShows(name: String): Response<APIResponse>
}