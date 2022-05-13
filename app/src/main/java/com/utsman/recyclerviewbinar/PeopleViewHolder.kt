package com.utsman.recyclerviewbinar

import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // binding -> istilah untuk setup view dengan data
    fun bind(people: People) {
        val tvName: TextView = itemView.findViewById(R.id.item_tv_name)
        val tvAge: TextView = itemView.findViewById(R.id.item_tv_age)

        tvName.text = people.name
        tvAge.text = people.age.toString()

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, "clicked on ${people.name}", Toast.LENGTH_SHORT).show()
        }
    }
}