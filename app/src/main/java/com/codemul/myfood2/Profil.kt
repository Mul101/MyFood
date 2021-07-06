package com.codemul.myfood2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Profil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        supportActionBar?.setTitle(R.string.Profile)

        //inisialisasi view nya
        val img_profil = findViewById<ImageView>(R.id.img_profil)
        val name_profil = findViewById<TextView>(R.id.name_profil)
        val email = findViewById<TextView>(R.id.email_profil)
        val github = findViewById<TextView>(R.id.github_profil)

        //ambil data dari Intent di main activity
        val name = intent.getStringExtra(MainActivity.intent_nama)
        val emailIntent = intent.getStringExtra(MainActivity.intent_email)
        val githubIntent = intent.getStringExtra(MainActivity.intent_github)
        //image
        val profilIntent = intent.getIntExtra(MainActivity.intent_profil_image, 0)

        name_profil.text = name
        email.text = emailIntent
        github.text = githubIntent
        img_profil.setImageResource(profilIntent)

    }

}