package com.example.groceries_mani

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ireport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        // Retrieve selected items and total price from intent extras
        val selectedProcessor = intent.getStringExtra("Brocolli")
        val selectedGraphicsCard = intent.getStringExtra("Ladiesfinger")
        val selectedRAM = intent.getStringExtra("Capsicum")
        val selectedMotherboard = intent.getStringExtra("Spinach")
        val selectedSSD = intent.getStringExtra("carrot")
        val selectedPowerSupply = intent.getStringExtra("Tomato")
        val totalPrice = intent.getIntExtra("TotalPrice", 0)

        // Display selected items and total price in TextViews
        val processorTextView = findViewById<TextView>(R.id.processorTextView)
        val graphicsCardTextView = findViewById<TextView>(R.id.graphicsCardTextView)
        val ramTextView = findViewById<TextView>(R.id.ramTextView)
        val motherboardTextView = findViewById<TextView>(R.id.motherboardTextView)
        val ssdTextView = findViewById<TextView>(R.id.ssdTextView)
        val powerSupplyTextView = findViewById<TextView>(R.id.powerSupplyTextView)
        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)

        processorTextView.text = "Brocolli: $selectedProcessor"
        graphicsCardTextView.text = "Ladiesfinger: $selectedGraphicsCard"
        ramTextView.text = "Capsicum: $selectedRAM"
        motherboardTextView.text = "Spinach: $selectedMotherboard"
        ssdTextView.text = "carrot: $selectedSSD"
        powerSupplyTextView.text = "Tomato: $selectedPowerSupply"
        totalPriceTextView.text = "Total Price: ₹$totalPrice"
    }
}
