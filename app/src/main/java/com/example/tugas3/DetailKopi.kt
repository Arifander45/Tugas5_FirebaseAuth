package com.example.tugas3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailKopi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)


        val gambar : ImageView = findViewById(R.id.imagedetail)
        val judul : TextView = findViewById(R.id.judulDetail)
        val ayat : TextView = findViewById(R.id.asaldetail)
        val detaill : TextView = findViewById(R.id.deskDetail)


        val bundle: Bundle?= intent.extras
        val bJudul = bundle!!.getString("jdl")
        val bGambar = bundle.getInt("img")
        val  bAsal = bundle.getString("asl")
        val bDetail = bundle.getString("dtl")


        gambar.setImageResource(bGambar)
        judul.text = bJudul
        ayat.text = bAsal
        detaill.text = bDetail


    }
}