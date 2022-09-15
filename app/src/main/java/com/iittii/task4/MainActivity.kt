package com.iittii.task4

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.iittii.task4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var sharedprefs: SharedPreferences?=null
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedprefs=getSharedPreferences("task4", MODE_PRIVATE)
          sharedprefs?.let {
           val name = it.getString("username", "").toString()
           val pass = it.getString("password", "").toString()
        }}



    fun Gotosecond(view: View) {
        if(sharedprefs==null){
        val intent =Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }else {
            val intent =Intent(this,HomeAcivity::class.java)
            startActivity(intent)
    }
    }
}