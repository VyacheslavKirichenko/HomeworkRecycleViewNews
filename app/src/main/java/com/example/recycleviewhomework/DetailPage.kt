package com.example.recycleviewhomework

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_activity.*


class DetailPage:AppCompatActivity () {
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
       // getActionBar()?.setDisplayHomeAsUpEnabled(true)


        if (intent !== null) {

            var id = intent.getStringExtra("id")
            var news2 = MainActivity.resultNews[(id).toInt()]
            if (news2 != null) {
                index = (id).toInt()
                lbl_title_detail.text = news2.Title
                lbl_context_detail.text = news2.Content

            }
        }
    }
    }


