package com.example.tioazis.submission2dicoding.fragment_nextEvent

import com.example.tioazis.submission2dicoding.api.ApiRepo
import com.example.tioazis.submission2dicoding.api.TheSportDBApi
import com.example.tioazis.submission2dicoding.model.EventResponse
import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class NextEventPresenter(private val view: NextEventView,
                         private val apiRepository: ApiRepo,
                         private val gson: Gson){

    fun getEventList(){
        view.showLoading()

        async(UI){
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getNextEvent()),
                        EventResponse::class.java)
            }
            view.showEventList(data.await().events)
            view.hideLoading()
        }
    }

}