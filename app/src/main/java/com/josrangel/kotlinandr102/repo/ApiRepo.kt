package com.josrangel.kotlinandr102.repo

import android.util.Log
import com.josrangel.kotlinandr102.SimpleBook
import com.josrangel.kotlinandr102.network.Api
import com.josrangel.kotlinandr102.network.BookResponse
import com.josrangel.kotlinandr102.network.PayloadItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepo {
    val api = Api()

    suspend fun getBooks() = withContext(Dispatchers.Default) {
        val result:BookResponse? = api.getBooks()
        Log.i("respuesta ",result.toString())
        val listBooks:List<SimpleBook?>? =result?.payload?.map{item ->
            item?.toSimpleBook()
        }
        return@withContext listBooks
    }

    fun PayloadItem.toSimpleBook() : SimpleBook{
        return SimpleBook(
            bookName = this.book ?: "",
            maxPrice = this.maximumPrice ?: "",
            minimumPrice = this.minimumPrice ?: ""
        )
    }

}