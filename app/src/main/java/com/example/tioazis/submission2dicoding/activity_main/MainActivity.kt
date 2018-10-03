package com.example.tioazis.submission2dicoding.activity_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tioazis.submission2dicoding.R
import com.example.tioazis.submission2dicoding.R.id.nextEvents
import com.example.tioazis.submission2dicoding.R.id.prevEvents
import com.example.tioazis.submission2dicoding.fragment_nextEvent.NextEventFragment
import com.example.tioazis.submission2dicoding.fragment_prevEvent.PrevEventFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                prevEvents -> {
                    loadPrevEventsFragment(savedInstanceState)
                }
                nextEvents -> {
                    loadNextEventsFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = prevEvents
    }

    private fun loadPrevEventsFragment(savedInstanceState:Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, PrevEventFragment(), PrevEventFragment::class.simpleName )
                    .commit()
        }

    }

    private fun loadNextEventsFragment(savedInstanceState:Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, NextEventFragment(), NextEventFragment::class.simpleName )
                    .commit()
        }

    }
}

