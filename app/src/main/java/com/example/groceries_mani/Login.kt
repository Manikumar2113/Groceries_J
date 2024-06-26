package com.example.groceries_mani

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Toast
import com.example.groceries_mani.databinding.ActivityLoginBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("users")

        binding.loginButton.setOnClickListener {
            val loginUsername = binding.loginUsername.text.toString()
            val loginPassword = binding.loginPassword.text.toString()

            if(loginUsername.isNotEmpty() && loginPassword.isNotEmpty()){
                loginUser(loginUsername, loginPassword)
            }
            else{
                Toast.makeText(this@Login, "All fields are mandatory", Toast.LENGTH_SHORT).show()

            }
        }
        binding.RegisterRedirect.setOnClickListener {
            startActivity(Intent(this@Login, Register::class.java))
            finish()
        }
    }

    private fun loginUser(username: String, password: String)
    {
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                if (dataSnapshot.exists())
                {
                    for (userSnapshot in dataSnapshot.children)
                    {
                        val userData = userSnapshot.getValue((users::class.java))
                        if(userData != null && userData.password == password)
                        {
                            Toast.makeText(this@Login, "Login Successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@Login, MainActivity::class.java))
                            finish()
                            return
                        }
                    }
                }
                Toast.makeText(this@Login, "Login Failed", Toast.LENGTH_SHORT).show()
            }
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@Login, "Database Error : ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}