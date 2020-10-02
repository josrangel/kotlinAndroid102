package com.josrangel.kotlinandr102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()
        setUpObservables()
    }

    private fun setUpObservables(){
        viewModel.listBooks.observe(this, Observer { list->
            val resultBooks = list?.joinToString () ?: " NO DATA"
            txtCriptos?.text = resultBooks
        })
    }

    private fun setUpListeners(){
        txtCriptos?.setOnClickListener{
            viewModel.getLastBooks()
        }
    }
}