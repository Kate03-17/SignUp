package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var signUpEmail: EditText
    private lateinit var signUpPassword: EditText
    private lateinit var signUpButton: Button
    private  lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        signUpEmail = findViewById(R.id.signUpEmail)
        signUpPassword = findViewById(R.id.signUpPassword)

        signUpButton = findViewById(R.id.signUpButton)

        signUpButton.setOnClickListener {
            val email = signUpEmail.text.toString()
            val password = signUpPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Parameter empty", Toast.LENGTH_SHORT).show()
            } else {

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "SignUp successful!", Toast.LENGTH_SHORT).show()
                    } else {

                        Toast.makeText(this, "Error, you may already be registered", Toast.LENGTH_SHORT).show()

                    }

                }



            }
        }

    }
}