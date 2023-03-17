package com.example.api26

import android.app.Activity
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val  context: Activity,val productArrayList : List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
   return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
   val currentItem = productArrayList[position]
        holder.titlie.text = currentItem.title
        holder.rating.text= currentItem.rating.toString()
     // how to to show image  in imageView  if image  in form of url ,  Using 3rd party Library called picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val  titlie:TextView
        val image:ShapeableImageView
        val rating:TextView
        init {
            titlie = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            rating = itemView.findViewById(R.id.ratingTV)
        }
    }

}