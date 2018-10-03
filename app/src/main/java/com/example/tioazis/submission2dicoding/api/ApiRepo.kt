package com.example.tioazis.submission2dicoding.api

import java.net.URL

class ApiRepo{
    fun doRequest(url:String):String{
        return URL(url).readText()
    }
}