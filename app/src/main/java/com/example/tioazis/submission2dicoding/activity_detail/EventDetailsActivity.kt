package com.example.tioazis.submission2dicoding.activity_detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.ScrollView
import kotlinx.android.synthetic.main.activity_event_details.*
import com.example.tioazis.submission2dicoding.R

class EventDetailsActivity : AppCompatActivity() {

    lateinit var presenter: EventDetailPresenter

    lateinit var progressView: ProgressBar
    lateinit var dataView:ScrollView

    lateinit var imgHomeBadge : ImageView
    lateinit var imgAwayBadge:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)


    }
}
