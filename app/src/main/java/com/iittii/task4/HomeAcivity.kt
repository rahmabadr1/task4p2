package com.iittii.task4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iittii.task4.databinding.ActivityHomeAcivityBinding

class HomeAcivity : AppCompatActivity() {
    private var sharedprefs: SharedPreferences? = null
    private lateinit var binding: ActivityHomeAcivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedprefs = getSharedPreferences("task4", MODE_PRIVATE)
        sharedprefs?.let {
            val name = it.getString("username", "")
            binding.show.text = name
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        sharedprefs?.let {
            it.edit().clear().apply()
        }
        Toast.makeText(this, "signed out", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }


}