package com.example.tioazis.submission2dicoding.fragment_prevEvent

import com.example.tioazis.submission2dicoding.model.Event

interface PrevEventView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}