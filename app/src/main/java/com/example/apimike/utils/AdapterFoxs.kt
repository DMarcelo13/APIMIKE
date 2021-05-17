package com.example.apimike.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apimike.R
import com.example.apimike.model.Fox
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_fox.view.*

class AdapterFoxs () : RecyclerView.Adapter<AdapterFoxs.ViewHolder>() {

    lateinit var items: ArrayList<Fox>

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }

    }
    fun setFoxs(items: List<Fox>) {
        this.items = items as ArrayList<Fox>
        notifyDataSetChanged()
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_fox, parent, false))

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.sizeInfo.text="${model.link}"
        Picasso.get()
                .load(model.image)
                .into(holder.foxImage)
    }
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val foxImage: ImageView = view.fox_image
        val sizeInfo: TextView = view.size_info

    }
}