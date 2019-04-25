package com.example.recycleviewhomework

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class NewsAdapter(context: Context, news: List<News>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context
    var news: List<News>


    init {
        this.context = context
        this.news = news

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return NewsHolder(inflater.inflate(R.layout.recycle_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newsInstance = news[position]
        val eh = holder as NewsHolder
        eh.to_lbl_context.setText(newsInstance.Content)
        eh.to_lbl_title.setText(newsInstance.Title)
        eh.ClickItem((position).toString())
    }

    override fun getItemCount(): Int {
        return news.size
    }

    internal class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var to_lbl_title: TextView
        var to_lbl_context: TextView

        init {
            to_lbl_title = itemView.findViewById(R.id.lbl_title_detail) as TextView
            to_lbl_context = itemView.findViewById(R.id.lbl_context_detail) as TextView

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