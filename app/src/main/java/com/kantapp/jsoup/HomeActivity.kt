package com.kantapp.jsoup

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.IOException
import java.lang.reflect.Method


@SuppressLint("Registered")
/**
 * Created by Android A on 4/25/2018.
 */
class HomeActivity:AppCompatActivity()
{
   private var result:TextView?=null
    private var click:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result=findViewById(R.id.result)
        click=findViewById(R.id.click)
        click!!.setOnClickListener {
            val requestQue=Volley.newRequestQueue(this)
            val stringRequest=StringRequest(Request.Method.GET,"https://www.drikpanchang.com/calendars/indian/indiancalendar.html?year=2019", Response.Listener<String> {
                response ->
                val doc=Jsoup.parse(response)
                val element=doc.select("tr")
                t(element.toString())


            }, Response.ErrorListener {
                error ->
                t("Error :"+error)
            })
            requestQue!!.add(stringRequest);
        }


    }



    fun t(message:String)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        Log.d("HomeActivity",message)
        result!!.setText(message)
    }
}