package com.example.cakestore

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import android.net.Uri
import androidx.annotation.Nullable
import coil.load
import com.squareup.picasso.Picasso
import wu.seal.jsontokotlin.utils.getIndent

class CakeDetails : AppCompatActivity() {
    lateinit var title_text: TextView
    lateinit var desc: TextView
    lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cake_details)
        var title = intent.getStringExtra("title")
        title_text = findViewById(R.id.title_text)
        title_text.text = title

        img = findViewById(R.id.cakeImage)
        var uri: Uri = Uri.parse(intent.getStringExtra("img"))
        img.setImageURI(uri)
        Picasso.get()
            .load(uri)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(img);
        desc = findViewById(R.id.details_txt)
        var d_desc = intent.getStringExtra("desc")
        desc.text = d_desc



    }
}