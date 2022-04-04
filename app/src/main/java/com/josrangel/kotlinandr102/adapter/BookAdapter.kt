package com.josrangel.kotlinandr102.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.josrangel.kotlinandr102.R
import com.josrangel.kotlinandr102.SimpleBook

class BookAdapter (private val mList: List<SimpleBook>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_book, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.tvBookName.text = ItemsViewModel.bookName.replace("_","/").toUpperCase()
        holder.tvMaxPrice.text = ItemsViewModel.maxPrice
        holder.tvMinPrice.text = ItemsViewModel.minimumPrice
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvBookName: TextView = itemView.findViewById(R.id.tv_book)
        val tvMaxPrice: TextView = itemView.findViewById(R.id.tv_max_price)
        val tvMinPrice: TextView = itemView.findViewById(R.id.tv_min_price)
    }
}