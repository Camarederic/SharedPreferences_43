package com.example.sharedpreferences_43

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences_43.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        binding.buttonSave.setOnClickListener {
            val userName = binding.editTextUserName.text.toString()
            val email = binding.editTextEmail.text.toString()

            editor.apply {
                putString("user_name", userName)
                putString("email", email)
                apply()
            }
        }

        binding.buttonLoad.setOnClickListener {
            val userName = sharedPref.getString("user_name", null)
            val email = sharedPref.getString("email", null)

            binding.textViewUserName.text = userName
            binding.textViewEmail.text = email
        }
    }
}