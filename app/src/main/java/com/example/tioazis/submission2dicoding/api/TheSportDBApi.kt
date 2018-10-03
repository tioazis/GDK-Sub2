package com.example.tioazis.submission2dicoding.api

import android.net.Uri
import com.example.tioazis.submission2dicoding.BuildConfig

object TheSportDBApi {


    fun getPastEvent():String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "eventspastleague.php?id=4387"
    }

    fun getNextEvent():String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "eventsnextleague.php?id=4387"
    }

    fun getEventDetail(id:String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "lookupevent.php?id="+ id
    }

    fun getTeamDetail(id:String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "lookupteam.php?id=" + id
    }


}