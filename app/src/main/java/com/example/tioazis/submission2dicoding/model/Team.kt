package com.example.tioazis.submission2dicoding.model

import com.google.gson.annotations.SerializedName

data class Team(
        @SerializedName("idTeam")
        val teamID: String?,

        @SerializedName("strTeamBadge")
        val TeamBadge: String?
)