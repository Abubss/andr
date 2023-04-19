package com.example.rk1

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.navbarbai.Profile
import com.example.navbarbai.Settings
import com.example.rk1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    lateinit var userArrayList: ArrayList<City>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //replaceFragment(Home())

        bind.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                R.id.profile -> replaceFragment(Profile())
                R.id.settings -> replaceFragment(Settings())


                else ->{



                }


            }

            true

        }

        val imageId = intArrayOf(
            R.drawable.kooper,
            R.drawable.newy,
            R.drawable.jeneva,
            R.drawable.dub,
            R.drawable.pekin,
            R.drawable.sid
        )

        val name = arrayOf(
            "Купертино",
            "Нью-Йорк",
            "Женева",
            "Дубай",
            "Пекин",
            "Сидней"
        )



        val lastMessages = arrayOf(
            "Сегодня, +0ч",
            "Завтра, +3ч",
            "Завтра, +9ч",
            "Завтра, +11ч",
            "Завтра, +15ч",
            "Завтра, +15ч"
        )


        val lastMsgTime = arrayOf(
            "09:00",
            "12:41",
            "18:41",
            "20:41",
            "00:41",
            "02:41"
        )


        val phoneNumber = arrayOf(
            "111111",
            "222222",
            "333333",
            "444444",
            "555555",
            "666666"
        )

        val country = arrayOf(
            "USA",
            "Russia",
            "Armenia",
            "China",
            "India",
            "Argentine"
        )





        userArrayList = ArrayList()

        for(i in name.indices){
            val user = City(name[i], lastMessages[i], lastMsgTime[i], phoneNumber[i], country[i], imageId[i])
            userArrayList.add(user)

        }

        bind.listview.isClickable = true
        bind.listview.adapter = MyAdapter(this, userArrayList)
        bind.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val phone = phoneNumber[position]
            val country = country[position]
            val imageId = imageId[position]


            val i = Intent(this, Info_country::class.java)
            i.putExtra("name", name)
            i.putExtra("phone", phone)
            i.putExtra("country", country)
            i.putExtra("imageId", imageId)

            var mPlayer= MediaPlayer.create(this, R.raw.voice)
            mPlayer.start()

            startActivity(i)

        }




    }

    private fun replaceFragment(fragment: Fragment){



        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()

    }

}