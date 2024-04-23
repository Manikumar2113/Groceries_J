package com.example.groceries_mani
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val imageButton1: View = findViewById(R.id.imageButton1)
        val imageButton2: View = findViewById(R.id.imageButton2)

        imageButton1.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        imageButton2.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}