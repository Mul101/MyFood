package com.codemul.myfood2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions

//unit adalah sebuah object di kotlin, mirip tipe void pada java
class HomeAdapter (
    private val listResep: ArrayList<Resep>,
    val context: Context,
    val listener: (Resep) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var names: TextView = itemView.findViewById(R.id.judul_resep)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo_resep)

        fun bindView(resep: Resep, listener: (Resep) -> Unit){
            imgPhoto.setImageResource(resep.images)
            names.text = resep.name
            itemView.setOnClickListener { listener(resep) }
        }
        //tidak bisa ditambah akan error karena id dibawah tidak termasuk kedalam layout home. jadi tidak bisa di ambil
        //var tvSteps_resep: TextView = itemView.findViewById(R.id.steps_resep)
    }

    //membuat viewHolder dari layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.home, parent, false)
        return ViewHolder(view)
    }
//    }

    override fun getItemCount(): Int {
        return listResep.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindView(listResep[position], listener)
        //inisialisasi dari data listResep
//        val resep= listResep[position]
//
//        Glide.with(holder.itemView.context)
//            .load(listResep[position].images)
//            //.apply(RequestOptions().override(350,550))
//            .into(holder.imgPhoto)
//
//        //mengambil data dari arraylist
//        holder.names.text = resep.name

        //holder.tvSteps_resep.text = resep.step_resep
    }

    //Inner Class adalah suatu Class yang didefinisikan di dalam Class lain.
    //anggota (member) dari Class lain, sama halnya seperti variable dan method.
//    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var names: TextView = itemView.findViewById(R.id.judul_resep)
//        var imgPhoto: ImageView = itemView.findViewById(R.id.img_photo_resep)
//        //var howToMake: TextView = itemView.findViewById(R.id.steps_resep)
//    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
//        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.home, parent, false)
//        return GridViewHolder(view)
//    }

}