package com.example.recycleviewhomework

class News(private var title: String,
           private var content: String) {

    var Title: String
        get() = title
        set(newValue) {
            title = newValue
        }

    var Content: String
        get() = content
        set(newValue) {
            content = newValue
        }
}