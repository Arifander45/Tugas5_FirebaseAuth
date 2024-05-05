package com.example.tugas3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas3.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth


class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var kopiRecyclerView: RecyclerView
    private lateinit var judul: Array<String>
    private lateinit var asal: Array<String>
    private lateinit var Gambar: Array<Int>

    private lateinit var Detail: Array<String>
    private lateinit var listKopi: ArrayList<DataItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()






        Gambar = arrayOf(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_1,
            R.drawable.img,
        )

        judul = arrayOf(
            "Kopi Moanemani",
            "Kopi  TAngma",
            "Kopi Kurima",
            "Kopi paniai"
        )

        asal = arrayOf(
            "Kabupaten Dogiyai",
            "Kabupaten Puncak",
            "Kbupaten Wamena",
            "Kabupaten Paniai"
        )


        Detail = arrayOf(

            getString(R.string.kopi),
            getString(R.string.kopi),
            getString(R.string.kopi),
            getString(R.string.kopi)
        )


        kopiRecyclerView = findViewById(R.id.hasil)
        kopiRecyclerView.layoutManager = LinearLayoutManager(this)

        listKopi = arrayListOf<DataItem>()
        getData()

    }

    private fun getData() {
        for (i in Gambar.indices) {
            val dataKopin = DataItem(Gambar[i], judul[i], asal[i])
            listKopi.add(dataKopin)
        }

        var adapter = Myadapter(listKopi)
        kopiRecyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : Myadapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@Home, DetailKopi::class.java)
                intent.putExtra("img", listKopi[position].img)
                intent.putExtra("jdl", listKopi[position].judul)
                intent.putExtra("asl", listKopi[position].asal)
                intent.putExtra("dtl", Detail[position])
                startActivity(intent)


            }

        })


        binding.logout.setOnClickListener {
            firebaseAuth.signOut()

            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)

            }

        }

    }

}
