package com.example.tioazis.submission2dicoding.fragment_nextEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.tioazis.submission2dicoding.R
import com.example.tioazis.submission2dicoding.api.ApiRepo
import com.example.tioazis.submission2dicoding.fragment_prevEvent.PrevEventAdapter
import com.example.tioazis.submission2dicoding.model.Event
import com.example.tioazis.submission2dicoding.utils.invisible
import com.example.tioazis.submission2dicoding.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_prev_event.*
import org.jetbrains.anko.support.v4.onRefresh


class NextEventFragment : Fragment(),NextEventView {


    private var events: MutableList<Event> = mutableListOf()
    private lateinit var adapter: NextEventAdapter
    private lateinit var listEvent: RecyclerView
    private lateinit var presenter: NextEventPresenter
    private lateinit var swipeRefresh: SwipeRefreshLayout



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = NextEventAdapter(events) {
            TODO("Masukkan proses masuk ke dalam detail event")
        }

        listEvent.adapter = adapter

        val request = ApiRepo()
        val gson = Gson()
        presenter = NextEventPresenter(this,request,gson)

        swipeRefresh.onRefresh {
            presenter.getEventList()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_event, container, false)
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showEventList(data: List<Event>) {
        swipeRefresh.isRefreshing = false
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }




}
