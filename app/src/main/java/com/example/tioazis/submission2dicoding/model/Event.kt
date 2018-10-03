package com.example.tioazis.submission2dicoding.model

import com.google.gson.annotations.SerializedName

data class Event(
        @SerializedName("idEvent")
    var EventID: String? = null,

        @SerializedName("strHomeTeam")
    var homeTeamName: String? = null,

        @SerializedName("strAwayTeam")
    var awayTeamName: String? = null,

        @SerializedName("intHomeScore")
    var homeScore: Int? = null,

        @SerializedName ("intAwayScore")
    var awayScore: Int? = null,

        @SerializedName("dateEvent")
    var dateEvent: String? = null

)