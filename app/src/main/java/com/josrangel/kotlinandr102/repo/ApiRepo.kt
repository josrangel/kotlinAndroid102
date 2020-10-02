package com.josrangel.kotlinandr102.repo

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
        val listBooks:List<SimpleBook?>? =result?.payload?.map{item ->
            item?.toSimpleBook()
        }
        return@withContext listBooks
    }

    fun PayloadItem.toSimpleBook() : SimpleBook{
        return SimpleBook(
            bookName = book ?: "",
            maxPrice = maximumPrice ?: ""
        )
    }

}