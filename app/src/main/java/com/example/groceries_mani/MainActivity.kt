package com.example.groceries_mani
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageButton1: View = findViewById(R.id.imageButton2)
        val imageButton2: View = findViewById(R.id.imageButton1)

        imageButton1.setOnClickListener {
            startActivity(Intent(this, Vegies::class.java))
        }

        imageButton2.setOnClickListener {
            startActivity(Intent(this, Fruits::class.java))
        }
    }
}
