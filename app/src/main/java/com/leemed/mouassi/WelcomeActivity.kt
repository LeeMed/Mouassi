package com.leemed.mouassi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leemed.mouassi.databinding.WelcomeActivityBinding

class WelcomeActivity : AppCompatActivity(){

    private lateinit var binding: WelcomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= WelcomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddPictureActivity::class.java))
        }


        binding.buttondown.setOnClickListener {
            startActivity(Intent(this, DownloadActivity::class.java))
        }


        binding.buttonphoto.setOnClickListener {
            startActivity(Intent(this, ShowActivity::class.java))
        }

        binding.buttonus.setOnClickListener {
            startActivity(Intent(this, UsActivity::class.java))
        }


    }












}
