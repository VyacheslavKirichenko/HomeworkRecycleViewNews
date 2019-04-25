package com.example.recycleviewhomework

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.koushikdutta.ion.Ion
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    companion object {
         var resultNews: ArrayList<News> = ArrayList()
    }
    private val API_KEY = "b34f14127ae348478d1d9b1eb7292375"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonSearchClick(view:View){
        val query = innput_field.text.toString().replace(" ","+")
        val urlString = "https://newsapi.org/v2/everything?q=$query&sortBy=date&apiKey=$API_KEY"

        Ion.with(this)
            .load(urlString)
            .asString()
            .setCallback { _, result ->
                Log.i("JSON", result)

                var articles = JSONArray()
                try{
                    articles = JSONObject(result).getJSONArray("articles")
                } catch(ex: Exception) {
                    Log.e("JSONObject","Can't parse JSON object! "+ex.message)
                }

                if(articles.length() > 0) {
                    for (i in 0..(articles.length()-1)) {
                        val title = articles.getJSONObject(i).getString("title")
                        val content = articles.getJSONObject(i).getString("content")
                       if (content !== null) {
                           resultNews.add(i, (News(title, content)))
                       }
                    }
                }
                loadContent()
            }
    }

    fun loadContent(){
        val adapter = NewsAdapter(this, resultNews)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_emp.setLayoutManager(layoutManager)
        rv_emp.adapter = adapter
    }

}
