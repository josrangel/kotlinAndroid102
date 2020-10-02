package com.josrangel.kotlinandr102.network

import retrofit2.Response
import retrofit2.http.GET

interface Endpoints {

    @GET("avaliable_books/")
    suspend fun books(): Response<BookResponse>
}
