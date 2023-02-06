package com.leemed.mouassi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leemed.mouassi.databinding.UseroActivityBinding
import java.lang.Exception

class UseroActivity : AppCompatActivity() {

    private lateinit var binding: UseroActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= UseroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.home.setOnClickListener {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }


        binding.aboutchefid.setOnClickListener {
            startActivity(Intent(this, AboutUsoActivity::class.java))


        }


        binding.helpid.setOnClickListener{

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("mouassi397@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Your subject here...")
            intent.putExtra(Intent.EXTRA_TEXT, "Tell us more about your problem")
            startActivity(intent)
        }


        binding.facebookid.setOnClickListener{

            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/100006347071961"))
                startActivity(intent)
            } catch (e: Exception) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://www.facebook.com/")
                    )
                )
            }
        }



        binding.instagramid.setOnClickListener {


            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.instagram.com/assia_aroussi/")
            startActivity(openURL)


        }

        binding.galleryid.setOnClickListener {


            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://drive.google.com/drive/u/2/folders/1-TuOSQl8Afwh0paVvJQl6JyT2U13Sbq1")
            startActivity(openURL)


        }

        binding.phoneid.setOnClickListener {


            val call = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0605978459"))
            startActivity(call)


        }





        binding.shareid.setOnClickListener {
            val message: String = "https://www.instagram.com/assia_aroussi/"

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Please select app: "))
        }
    }


}