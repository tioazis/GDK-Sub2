package com.example.tioazis.submission2dicoding.fragment_prevEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_prev_event.*
import com.example.tioazis.submission2dicoding.R
import com.example.tioazis.submission2dicoding.api.ApiRepo
import com.example.tioazis.submission2dicoding.model.Event
import com.example.tioazis.submission2dicoding.utils.invisible
import com.example.tioazis.submission2dicoding.utils.visible
import com.google.gson.Gson
import org.jetbrains.anko.support.v4.onRefresh


class PrevEventFragment : Fragment(),PrevEventView {

    private var events: MutableList<Event> = mutableListOf()
    private lateinit var adapter: PrevEventAdapter
    private lateinit var listEvent:RecyclerView
    private lateinit var presenter:PrevEventPresenter
    private lateinit var swipeRefresh:SwipeRefreshLayout



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = PrevEventAdapter(events){
            TODO("Masukkan proses masuk ke dalam detail event")
        }

        listEvent.adapter = adapter

        val request = ApiRepo()
        val gson = Gson()
        presenter = PrevEventPresenter(this,request,gson)

        swipeRefresh.onRefresh {
            presenter.getEventList()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_prev_event, container, false)
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
