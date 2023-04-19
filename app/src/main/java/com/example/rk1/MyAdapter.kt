package com.example.rk1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<City>) : ArrayAdapter<City>(context,
    R.layout.clocks_main, arrayList)        {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflator: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflator.inflate(R.layout.clocks_main, null)

        val imageView: ImageView = view.findViewById(R.id.profile_pic)
        val userName: TextView = view.findViewById(R.id.person_name)
        val lastMsg: TextView = view.findViewById(R.id.lastMessage)
        val lastMsgtime: TextView = view.findViewById(R.id.msgtime)

        imageView.setImageResource(arrayList[position].imageId)
        userName.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMessage
        lastMsgtime.text = arrayList[position].lastMsgTime


        return view
    }
}