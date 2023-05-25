package com.example.group1FirebaseProject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class UpdatePasswordActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        val newPasswordET = findViewById<EditText>(R.id.newPasswordET)

        findViewById<Button>(R.id.updatePasswordBtn).setOnClickListener {
            val password = newPasswordET.text.toString()

            auth.currentUser!!.updatePassword(password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfully updated password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to update password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}