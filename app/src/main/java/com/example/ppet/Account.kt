package com.example.ppet

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.content.Context

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.create_account)
        button.setOnClickListener {
            val nickname = findViewById<EditText>(R.id.nickname).text.toString()
            val sharedPref = getSharedPreferences("ppet", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("nickname", nickname)
                apply()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}