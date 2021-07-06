package com.codemul.myfood2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //lateinittidak dapat digunakan untuk properti non-nullable dan tipe primitif Java
    private lateinit var rvResep: RecyclerView
    private var list: ArrayList<Resep> = arrayListOf()

    //seperti static method
    companion object{
        const val intent_resep = "object_intent"
        const val intent_nama = "object_nama"
        const val intent_email = "object_email"
        const val intent_profil_image = "object_profil"
        const val intent_github = "object_github"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setTitle(R.string.Home)

        //masuk ke recyclerView
        rvResep = findViewById(R.id.rv_Resep)
        rvResep.setHasFixedSize(true)

        //menambah data dari arrayList, listResep
        list.addAll(ResepData.listResep)

        //menampilkan data yang ada pada fungsi tersebut
        showRecycleGrid()
    }

    //untuk menampilkan menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        selected(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    //memilih menu
    private fun selected(select: Int){
        when(select){
            R.id.profil->{
            showMenuProfil()
            }
        }
    }

    private fun showRecycleGrid(){
        rvResep.layoutManager = GridLayoutManager(this, 2)
        //rvResep.adapter = HomeAdapter(list)
        rvResep.adapter = HomeAdapter(list, this){
            val intent = Intent(this, DetailResep::class.java)
            intent.putExtra(intent_resep, it)
            startActivity(intent)
        }
    }

    //menampilkan menu profil
    private fun showMenuProfil(){
        val intent = Intent(this, Profil::class.java)
        intent.putExtra(intent_nama, "Mulia Dea Lestari")
        intent.putExtra(intent_email, "mulia4404@gmail.com")
        intent.putExtra(intent_github, "Mul101")
        intent.putExtra(intent_profil_image, R.drawable.img_profil)
        //jgn lupa untuk startActivityuntuk menjalankan aktivity agar bisa terlihat
        startActivity(intent)
    }

}