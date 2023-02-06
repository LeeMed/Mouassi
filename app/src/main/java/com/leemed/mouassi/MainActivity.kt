package com.leemed.mouassi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.leemed.mouassi.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_Mouassi)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.buttonlog.setOnClickListener {
           startActivity(Intent(this, LoginActivity::class.java))

       }

        binding.buttonreg.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))

        }





    }





}
