package com.utsman.recyclerviewbinar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val peopleList = listOf<People>(
        People("Ucup", 31),
        People("Anton", 21),
        People("Narto", 42),
        People("Ronaldo", 34),
        People("Fahri", 21),
        People("Dinda", 32)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val peopleRecyclerView: RecyclerView = findViewById(R.id.main_rv)
        val peopleEtAdded: EditText = findViewById(R.id.main_et_add)
        val peopleBtnAdded: Button = findViewById(R.id.main_btn_add)

        val peopleLayoutManager = LinearLayoutManager(this)
        val peopleAdapter = PeopleAdapter()

        peopleRecyclerView.layoutManager = peopleLayoutManager
        peopleRecyclerView.adapter = peopleAdapter

        peopleAdapter.addList(peopleList)

        peopleBtnAdded.setOnClickListener {
            val nameEdit = peopleEtAdded.text.toString()
            val randomAge = (10..40).random()

            val people = People(nameEdit, randomAge)
            peopleAdapter.addItem(people)

            val sizePeople = peopleAdapter.itemCount - 1
            peopleRecyclerView.scrollToPosition(sizePeople)

            peopleEtAdded.setText("")
        }
    }
}