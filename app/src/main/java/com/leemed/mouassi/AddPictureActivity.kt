package com.leemed.mouassi

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.leemed.mouassi.databinding.AddPictureActivityBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext



private const val REQUEST_CODE_IMAGE_PICK = 0

class AddPictureActivity : AppCompatActivity() {

    var curFile: Uri? = null

    val imageRef = Firebase.storage.reference

    private lateinit var binding: AddPictureActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= AddPictureActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.ivImage.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }


        binding.btnUploadImage.setOnClickListener {
            uploadImageToStorage(binding.textView5.text.toString())
        }


        binding.btnDeleteImage.setOnClickListener {
            deleteImage(binding.textView5.text.toString())
        }


        binding.buttonback.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
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



    private fun deleteImage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            imageRef.child("images/$filename").delete().await()
            withContext(Dispatchers.Main) {
                Toast.makeText(this@AddPictureActivity, "Successfully deleted image.",
                    Toast.LENGTH_LONG).show()
            }
        } catch(e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(this@AddPictureActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }

    }


    private fun uploadImageToStorage(filename: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            curFile?.let {
                imageRef.child("images/$filename").putFile(it).await()
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@AddPictureActivity, "Successfully uploaded image",
                        Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                Toast.makeText(this@AddPictureActivity, e.message, Toast.LENGTH_LONG).show()
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