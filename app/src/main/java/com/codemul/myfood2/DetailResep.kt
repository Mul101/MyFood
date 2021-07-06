package com.codemul.myfood2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class DetailResep : AppCompatActivity() {

    private lateinit var resep: Resep
    private lateinit var photo: ImageView
    private lateinit var name: TextView
    private lateinit var detail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resep)

        supportActionBar?.setTitle("How to Make")

        //intent menggunakan parcelable,
        //dengan menggunakan Parcelable maka data yang akan kita kirim dapat mencakup banyak data
        resep = intent.getParcelableExtra<Resep>(MainActivity.intent_resep)

        photo = findViewById<ImageView>(R.id.img_resep)
        name = findViewById<TextView>(R.id.detail_judul)
        detail = findViewById<TextView>(R.id.steps_resep)

        photo.setImageResource(resep.images)
        name.text = resep?.name
        detail.text = resep?.step_resep
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //memilih menu
    override fun onOptionsItemSelected(item: MenuItem) :Boolean {
        selected(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    //memilih menu
    private fun selected(select: Int){
        when(select){
            R.id.favorite->{
                Toast.makeText(this, "I like this food", Toast.LENGTH_SHORT).show()
            }
            R.id.share->{
                //val tv: TextView = name.findViewById(R.id.detail_judul)
                name.text = resep.name
                detail.text = resep.step_resep
                val image = photo.setImageResource(resep.images)
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra (Intent.EXTRA_TEXT,    name.text as String +"\n\n"+ detail.text)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
                //Toast.makeText(this, "I love this", Toast.LENGTH_SHORT).show()
            }
        }
    }
}