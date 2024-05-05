package com.example.tugas3


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class Myadapter (private val namaList: ArrayList<DataItem>):RecyclerView.Adapter<Myadapter.MyViewHolder>(){
    private lateinit var mListener: onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : ViewHolder(itemView){
        val gambar:ImageView = itemView.findViewById(R.id.kopi)
        val judul:TextView = itemView.findViewById(R.id.nama)
        val asal:TextView = itemView.findViewById(R.id.asal)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return namaList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.img)
        holder.judul.text = currentItem.judul
        holder.asal.text = currentItem.asal

    }

}