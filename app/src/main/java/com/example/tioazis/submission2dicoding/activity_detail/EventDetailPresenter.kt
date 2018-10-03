package com.example.tioazis.submission2dicoding.activity_detail

import com.example.tioazis.submission2dicoding.api.ApiRepo
import com.example.tioazis.submission2dicoding.api.TheSportDBApi
import com.example.tioazis.submission2dicoding.model.EventResponse
import com.example.tioazis.submission2dicoding.model.TeamDetailsResponse
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventDetailPresenter (val view:EventDetailsView){
    val apiRepository = ApiRepo()
    val gson = Gson()

    fun getTeamDetails(idHomeTeam:String, idAwayTeam: String){
        view.showLoading()

        doAsync {
            val dataHomeTeam = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(idHomeTeam)),
                    TeamDetailsResponse::class.java)

            val dataAwayTeam = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(idAwayTeam)),
                    TeamDetailsResponse::class.java)



            uiThread {
                view.hideLoading()
                view.showTeamDetails(dataHomeTeam.teams!!, dataAwayTeam.teams!!)
            }
        }

    }

    fun getEventDetails(idEvent:String){
        view.showLoading()

        doAsync {
            val dataEvent = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getEventDetail(idEvent)),
                    EventResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showEventDetails(dataEvent.events!!)
            }

        }

    }


}