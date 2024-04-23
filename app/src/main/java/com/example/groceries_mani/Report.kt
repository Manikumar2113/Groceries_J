package com.example.groceries_mani

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Report : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        // Retrieve selected items and total price from intent extras
        val selectedProcessor = intent.getStringExtra("Pineapple")
        val selectedGraphicsCard = intent.getStringExtra("Orange")
        val selectedRAM = intent.getStringExtra("Kiwi")
        val selectedMotherboard = intent.getStringExtra("PassionFruit")
        val selectedSSD = intent.getStringExtra("Pears")
        val selectedPowerSupply = intent.getStringExtra("Peach")
        val selectedCabinet = intent.getStringExtra("Strawberry")
        val totalPrice = intent.getIntExtra("TotalPrice", 0)

        // Display selected items and total price in TextViews
        val processorTextView = findViewById<TextView>(R.id.processorTextView)
        val graphicsCardTextView = findViewById<TextView>(R.id.graphicsCardTextView)
        val ramTextView = findViewById<TextView>(R.id.ramTextView)
        val motherboardTextView = findViewById<TextView>(R.id.motherboardTextView)
        val ssdTextView = findViewById<TextView>(R.id.ssdTextView)
        val powerSupplyTextView = findViewById<TextView>(R.id.powerSupplyTextView)
        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)

        processorTextView.text = "Pineapple: $selectedProcessor"
        graphicsCardTextView.text = "Orange: $selectedGraphicsCard"
        ramTextView.text = "Kiwi: $selectedRAM"
        motherboardTextView.text = "PassionFruit: $selectedMotherboard"
        ssdTextView.text = "Pears: $selectedSSD"
        powerSupplyTextView.text = "Peach: $selectedPowerSupply"
        totalPriceTextView.text = "Total Price: ₹$totalPrice"
    }
}
