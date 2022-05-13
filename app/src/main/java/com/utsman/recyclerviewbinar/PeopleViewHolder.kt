package com.utsman.recyclerviewbinar

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val catImageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2021/10/28064854/12.-Tips-Merawat-Anak-Kucing-Munchkin.jpg"

    // example random image urlL: https://source.unsplash.com/500x500/?home
    private val imageUrl = "https://source.unsplash.com/500x500/?"

    // binding -> istilah untuk setup view dengan data
    fun bind(people: People) {
        val tvName: TextView = itemView.findViewById(R.id.item_tv_name)
        val tvAge: TextView = itemView.findViewById(R.id.item_tv_age)
        val imgProfile: ImageView = itemView.findViewById(R.id.item_img_profile)

        tvName.text = people.name
        tvAge.text = people.age.toString()

        val glideImageUrl = "$imageUrl${people.imageKeyword}"
        Glide.with(itemView.context)
            .load(glideImageUrl)
            .into(imgProfile)

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, "clicked on ${people.name}", Toast.LENGTH_SHORT).show()
        }
    }
}