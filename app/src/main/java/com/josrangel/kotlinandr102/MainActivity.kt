package com.josrangel.kotlinandr102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import com.josrangel.kotlinandr102.adapter.BookAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * Source:
 * Skeleton animation: https://jagar.me/post/how_to_create_skeleton_loading_view_for_any_recyclervie_or_view/
 */
class MainActivity : AppCompatActivity() {

    lateinit var bookAdapter: BookAdapter
    lateinit var skeletonScreen: RecyclerViewSkeletonScreen.Builder
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()
        setUpObservables()
        initRecyclerView(Arrays.asList())
        initSkeleton()
        chargeBooks()
    }

    private fun setUpObservables(){
        //se define el observador para pasar la informacion al textview
        viewModel.listBooks.observe(this, Observer { list->
            //en caso de que la respuesta sea nula se le asignara NO DATA
            val resultBooks = list?.joinToString () ?: " NO DATA"
            //txtCriptos?.text = resultBooks
            val listBooks = list?.let { it } ?: listOf()
            initRecyclerView(listBooks)
        })
    }

    private fun setUpListeners(){
        //se crea un listener en el textview para cuando se de click en el, mande a pedir los datos
        txtCriptos?.setOnClickListener{
            chargeBooks()
        }
    }

    private fun chargeBooks(){
        showSkeleton()
        viewModel.getLastBooks()
    }

    private fun initRecyclerView(dataRV: List<SimpleBook?>) {
        val linearLayoutManager = LinearLayoutManager(this)
        rvBooks.layoutManager = linearLayoutManager
        bookAdapter = BookAdapter(dataRV as List<SimpleBook>)
        // Setting the Adapter with the recyclerview
        rvBooks.adapter = bookAdapter
    }

    private fun initSkeleton(){
        skeletonScreen = Skeleton.bind(rvBooks)
            .adapter(bookAdapter)
            .load(R.layout.skeleton_item_view)
    }

    fun showSkeleton(){
        skeletonScreen.show()
    }
}