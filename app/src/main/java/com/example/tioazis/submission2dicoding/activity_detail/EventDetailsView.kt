package com.example.tioazis.submission2dicoding.activity_detail

import com.example.tioazis.submission2dicoding.model.Event
import com.example.tioazis.submission2dicoding.model.Team

interface EventDetailsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetails(dataHomeTeam: List<Team>, dataAwayTeam: List<Team>)
    fun showEventDetails(dataEvent: List<Event>)
}