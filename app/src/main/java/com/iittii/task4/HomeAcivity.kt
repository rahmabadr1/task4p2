package com.iittii.task4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.iittii.task4.databinding.ActivityHomeAcivityBinding
import com.iittii.task4.databinding.ActivityMainBinding

class HomeAcivity : AppCompatActivity() {
    private var sharedprefs:SharedPreferences?=null
    private lateinit var binding: ActivityHomeAcivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeAcivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedprefs=getSharedPreferences("task4", MODE_PRIVATE)
        sharedprefs?.let {
           val name= it.getString("username","")
            binding.show.text=name
            val pass=it.getString("password","")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            sharedprefs=null
        Toast.makeText(this,"signed out",Toast.LENGTH_SHORT) .show()
        val intent=Intent(this,SecondActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }



}