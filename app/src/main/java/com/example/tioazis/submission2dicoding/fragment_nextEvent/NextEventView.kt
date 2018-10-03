package com.example.tioazis.submission2dicoding.fragment_nextEvent

import com.example.tioazis.submission2dicoding.model.Event

interface NextEventView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}