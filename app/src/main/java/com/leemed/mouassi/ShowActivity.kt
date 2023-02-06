package com.leemed.mouassi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leemed.mouassi.databinding.ShowActivityBinding
import com.leemed.mouassi.databinding.WelcomeActivityBinding

class ShowActivity: AppCompatActivity() {

    private lateinit var binding: ShowActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= ShowActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.driveid.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://drive.google.com/drive/u/2/folders/1--Di0KbqjJNPasHNnrZWVPw3_NupA_hs")
            startActivity(openURL)

        }

        binding.fireid.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://console.firebase.google.com/u/0/project/mouassi-42228/storage/mouassi-42228.appspot.com/files/~2Fimages")
            startActivity(openURL)
        }

        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddPictureActivity::class.java))
        }


        binding.buttondown.setOnClickListener {
            startActivity(Intent(this, DownloadActivity::class.java))
        }


        binding.buttonback.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.buttonus.setOnClickListener {
            startActivity(Intent(this, UsActivity::class.java))
        }


    }





}








