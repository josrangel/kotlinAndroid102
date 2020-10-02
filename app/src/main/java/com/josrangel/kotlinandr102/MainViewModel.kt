package com.josrangel.kotlinandr102

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josrangel.kotlinandr102.repo.ApiRepo
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val repo = ApiRepo()

    private val mutableListBooks = MutableLiveData<List<SimpleBook?>?>()

    val listBooks:LiveData<List<SimpleBook?>?>
        get() = mutableListBooks



    fun getLastBooks(){
        viewModelScope.launch {
            val result = repo.getBooks()
            mutableListBooks.value = result
        }

    }
}