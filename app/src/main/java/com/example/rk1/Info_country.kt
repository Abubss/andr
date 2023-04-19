package com.example.rk1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rk1.databinding.ActivityInfoCountryBinding

class Info_country : AppCompatActivity() {
    lateinit var bindUser: ActivityInfoCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindUser = ActivityInfoCountryBinding.inflate(layoutInflater)
        setContentView(bindUser.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val country = intent.getStringExtra("country")
        val imageid = intent.getIntExtra("imageId", R.drawable.kooper)


        bindUser.nameProfile.text = name
        bindUser.phoneProfile.text = phone
        bindUser.countryProfile.text = country
        bindUser.profileImage.setImageResource(imageid)
    }
}