package com.leemed.mouassi

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.leemed.mouassi.databinding.DownloadActivityBinding

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

private const val REQUEST_CODE_IMAGE_PICK = 0

class DownloadActivity : AppCompatActivity() {
    var curFile: Uri? = null

    val imageRef = Firebase.storage.reference

    private lateinit var binding: DownloadActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= DownloadActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.ivImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }




        binding.btnDownloadImage.setOnClickListener {
            downloadImage(binding.textView5.text.toString())
        }

        binding.buttonback.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }

        binding.fab.setOnClickListener {
            startActivity(Intent(this, AddPictureActivity::class.java))
        }
        binding.buttonphoto.setOnClickListener {
            startActivity(Intent(this, ShowActivity::class.java))
        }

        binding.buttonus.setOnClickListener {
            startActivity(Intent(this, UsActivity::class.java))
        }











    }





    private fun downloadImage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val maxDownloadSize = 5L * 1024 * 1024
            val bytes = imageRef.child("images/$filename").getBytes(maxDownloadSize).await()
            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            withContext(Dispatchers.Main) {
                binding.ivImage.setImageBitmap(bmp)
            }
        } catch(e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(this@DownloadActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data?.let {
                curFile = it
                binding.ivImage.setImageURI(it)
            }
        }
    }

}