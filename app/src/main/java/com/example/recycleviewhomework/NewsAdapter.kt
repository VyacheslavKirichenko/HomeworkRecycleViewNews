package com.example.recycleviewhomework

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class NewsAdapter(context: Context, emps: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context
    var news: List<News>


    init {
        this.context = context
        this.news = emps

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return EmployeHolder(inflater.inflate(R.layout.second_layout, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employe = news[position]
        val eh = holder as EmployeHolder
        eh.lbl_designation.setText(employe.Content)
        eh.lbl_name.setText(employe.Title)
        eh.ClickItem((position).toString())
    }

    override fun getItemCount(): Int {
        return news.size
    }

    internal class EmployeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var lbl_name: TextView
        var lbl_designation: TextView

        init {
            lbl_name = itemView.findViewById(R.id.lbl_title) as TextView
            lbl_designation = itemView.findViewById(R.id.lbl_context) as TextView

        }
        fun ClickItem(id: String) {
            itemView.setOnClickListener {
                val inten = Intent(itemView.context, DetailPage::class.java)
                inten.putExtra("id", id)
                itemView.context.startActivity(inten)
            }
        }

    }

}