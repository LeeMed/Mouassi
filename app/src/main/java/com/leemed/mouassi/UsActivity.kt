package com.leemed.mouassi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leemed.mouassi.databinding.ShowActivityBinding
import com.leemed.mouassi.databinding.UsActivityBinding

class UsActivity: AppCompatActivity() {

    private lateinit var binding: UsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= UsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddPictureActivity::class.java))
        }


        binding.buttondown.setOnClickListener {
            startActivity(Intent(this, DownloadActivity::class.java))
        }


        binding.buttonback.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.buttonphoto.setOnClickListener {
            startActivity(Intent(this, ShowActivity::class.java))
        }

        binding.userid1.setOnClickListener {
            startActivity(Intent(this, UsermActivity::class.java))

        }

        binding.userid2.setOnClickListener {
            startActivity(Intent(this, UseroActivity::class.java))

        }




    }





}