package com.example.groceries_mani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class Vegies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegies)
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)
        val spinner4 = findViewById<Spinner>(R.id.spinner4)
        val spinner5 = findViewById<Spinner>(R.id.spinner5)
        val spinner6 = findViewById<Spinner>(R.id.spinner6)

        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)

        val totalPriceTextView = findViewById<TextView>(R.id.totalPriceTextView)

        val completeButton = findViewById<Button>(R.id.completeButton)

        // Arrays for prices
        val cpuPrices = resources.getStringArray(R.array.icpu_prices)
        val gpuPrices = resources.getStringArray(R.array.igpu_prices)
        val ramPrices = resources.getStringArray(R.array.iram_prices)
        val mbPrices = resources.getStringArray(R.array.imb_prices)
        val ssdPrices = resources.getStringArray(R.array.issd_prices)
        val psuPrices = resources.getStringArray(R.array.ipsu_prices)

        var totalPrice = 0

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem != "Brocolli") {
                    // Fetch price based on selected item position
                    val price = cpuPrices[position - 1] // Adjust index because of the header item
                    totalPrice += price.substring(1).replace(",", "").toInt()
                    totalPriceTextView.text = "Total Price: ₹$totalPrice"

                    Toast.makeText(this@Vegies, "$selectedItem - Price: $price", Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem != "Ladiesfinger") {
                    // Fetch price based on selected item position
                    val price = gpuPrices[position - 1] // Adjust index because of the header item
                    totalPrice += price.substring(1).replace(",", "").toInt()
                    totalPriceTextView.text = "Total Price: ₹$totalPrice"

                    Toast.makeText(this@Vegies, "$selectedItem - Price: $price", Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem != "Capsicum") {
                    // Fetch price based on selected item position
                    val price = ramPrices[position - 1] // Adjust index because of the header item
                    totalPrice += price.substring(1).replace(",", "").toInt()
                    totalPriceTextView.text = "Total Price: ₹$totalPrice"

                    Toast.makeText(this@Vegies, "$selectedItem - Price: $price", Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem != "Spinach") {
                    // Fetch price based on selected item position
                    val price = mbPrices[position - 1] // Adjust index because of the header item
                    totalPrice += price.substring(1).replace(",", "").toInt()
                    totalPriceTextView.text = "Total Price: ₹$totalPrice"

                    Toast.makeText(this@Vegies, "$selectedItem - Price: $price", Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }
        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem != "carrot") {
                    // Fetch price based on selected item position
                    val price = ssdPrices[position - 1] // Adjust index because of the header item
                    totalPrice += price.substring(1).replace(",", "").toInt()
                    totalPriceTextView.text = "Total Price: ₹$totalPrice"

                    Toast.makeText(this@Vegies, "$selectedItem - Price: $price", Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }
        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                if (selectedItem != "Tomato") {
                    // Fetch price based on selected item position
                    val price = psuPrices[position - 1] // Adjust index because of the header item
                    totalPrice += price.substring(1).replace(",", "").toInt()
                    totalPriceTextView.text = "Total Price: ₹$totalPrice"

                    Toast.makeText(this@Vegies, "$selectedItem - Price: $price", Toast.LENGTH_SHORT).show()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected
            }
        }

        completeButton.setOnClickListener {
            val selectedProcessor = spinner1.selectedItem.toString()
            val selectedGraphicsCard = spinner2.selectedItem.toString()
            val selectedRAM = spinner3.selectedItem.toString()
            val selectedMotherboard = spinner4.selectedItem.toString()
            val selectedSSD = spinner5.selectedItem.toString()
            val selectedPowerSupply = spinner6.selectedItem.toString()


            if (selectedProcessor == "Processors" || selectedGraphicsCard == "Graphics Cards" || selectedRAM == "Ram" ||
                selectedMotherboard == "MotherBoard" || selectedSSD == "SSD" || selectedPowerSupply == "Power Supply") {
                Toast.makeText(this@Vegies, "Please complete the build by selecting options for all components.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@Vegies, ireport::class.java)
                intent.putExtra("Brocoli", selectedProcessor)
                intent.putExtra("Ladiesfinger", selectedGraphicsCard)
                intent.putExtra("Capsicum", selectedRAM)
                intent.putExtra("Spinach", selectedMotherboard)
                intent.putExtra("Carrot", selectedSSD)
                intent.putExtra("Tomato", selectedPowerSupply)
                intent.putExtra("TotalPrice", totalPrice)// Assuming totalPrice is an integer
                startActivity(intent)
            }
        }

    }
}