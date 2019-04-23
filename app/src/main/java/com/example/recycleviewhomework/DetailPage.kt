package com.example.recycleviewhomework

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_activity.*


class DetailPage:AppCompatActivity () {
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        getActionBar()?.setDisplayHomeAsUpEnabled(true)

        var entries = MainActivity.resultNews

        if(intent.hasExtra("ID")){
            id = intent.getIntExtra("ID",0)
            lbl_title.text = entries[id].Title
            lbl_context.text = entries[id].Content
        }
    }
    }


