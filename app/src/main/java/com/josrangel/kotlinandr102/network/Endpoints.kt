package com.josrangel.kotlinandr102.network

import retrofit2.Response
import retrofit2.http.GET
//se crea una interfaz donde se definiran nuestros endpoints para consultar la informacion
interface Endpoints {

    @GET("available_books/")
    //se especifica como se llamara la funcion y que tipo de respuesta se obtendra
    suspend fun books(): Response<BookResponse>
}
