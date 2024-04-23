package com.example.groceries_mani
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.groceries_mani.databinding.ActivityRegisterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Register : AppCompatActivity()
{
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("users")

        binding.registerButton.setOnClickListener{
            val registerUsername = binding.registerUsername.text.toString()
            val registerPassword = binding.registerPassword.text.toString()

            if(registerUsername.isNotEmpty() && registerPassword.isNotEmpty()){
                registerUser(registerUsername, registerPassword)
            }
            else{
                Toast.makeText(this@Register, "All fields are mandatory", Toast.LENGTH_SHORT).show()

            }
        }
        binding.LoginRedirect.setOnClickListener {
            startActivity(Intent(this@Register, Login::class.java))
            finish()
        }
    }

    private fun registerUser(username: String, password: String)
    {
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot)
            {
                if(!dataSnapshot.exists())
                {
                    val id = databaseReference.push().key
                    val userData = users(id, username, password)
                    databaseReference.child(id!!).setValue(userData)
                    Toast.makeText(this@Register, "Registration Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@Register, Login::class.java))
                    finish()
                }
                else
                {
                    Toast.makeText(this@Register, "User Already Exists", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@Register, "Database Error : ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}