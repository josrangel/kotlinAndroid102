package com.josrangel.kotlinandr102.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.create

class Api {
    //se crea el builder de retrofit para hacer la conexion al la api
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.bitso.com/v3/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    suspend fun getBooks() = withContext(Dispatchers.IO){
        val bookEndpoint:Endpoints = retrofit.create<Endpoints>()
        Log.i("respuestah ",bookEndpoint.books().headers().toString())
        val response:Response<BookResponse> = bookEndpoint.books()
        return@withContext if (response.isSuccessful){
            response.body()
        }else{
            null
        }
    }


}