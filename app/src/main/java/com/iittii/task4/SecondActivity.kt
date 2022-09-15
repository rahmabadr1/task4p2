package com.iittii.task4

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.iittii.task4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var pass: EditText
    private var sharedprefs: SharedPreferences? = null
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedprefs = getSharedPreferences("task4", MODE_PRIVATE)
        name = binding.username
        pass = binding.password
    }


    fun saveInlocalShared() {
        sharedprefs?.let {
            val editor: SharedPreferences.Editor = it.edit()
            editor.putString("username", name.text.toString()).apply()
        }
    }

    fun viewfromlocalShared(view: View) {
        sharedprefs?.let {
            val name = it.getString("username", "")
            val pass = it.getString("password", "")
        }
    }

    fun GotoHome(view: View) {
        if (binding.username.text == null) {
            Toast.makeText(this, "plase enter username", Toast.LENGTH_SHORT).show()
        } else if (binding.password.text == null) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "confirmed", Toast.LENGTH_LONG).show()
            saveInlocalShared()
            val intent = Intent(this, HomeAcivity::class.java)
            startActivity(intent)
        }
    }
}