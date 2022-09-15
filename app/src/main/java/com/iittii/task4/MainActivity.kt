package com.iittii.task4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.iittii.task4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var sharedprefs: SharedPreferences? = null
    private lateinit var binding: ActivityMainBinding

    private var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedprefs = getSharedPreferences("task4", MODE_PRIVATE)
        sharedprefs?.let {
            name = it.getString("username", "").toString()
        }

        Log.d("TAG", "onCreate: $name")
        if (name.isNotEmpty()){
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)
        }

    }


    fun Gotosecond(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}