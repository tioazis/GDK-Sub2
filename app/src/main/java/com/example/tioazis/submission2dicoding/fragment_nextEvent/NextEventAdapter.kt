package com.example.tioazis.submission2dicoding.fragment_nextEvent

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tioazis.submission2dicoding.R
import com.example.tioazis.submission2dicoding.model.Event
import org.jetbrains.anko.sdk25.coroutines.onClick

class NextEventAdapter(private val events:List<Event>, private val listener:(Event) -> Unit) :
        RecyclerView.Adapter<NextEventAdapter.NextEventHolder>(){

    override fun onBindViewHolder(holder: NextEventHolder, position: Int) {
        holder.bindEvents(events [position],listener)
    }

    override fun getItemCount(): Int = events.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextEventHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.events,parent,false)

        return NextEventHolder(view)

    }

    class NextEventHolder(view: View): RecyclerView.ViewHolder(view){
        private val homeTeam: TextView = view.findViewById(R.id.tv_homeTeamName)
        private val homeScore: TextView = view.findViewById(R.id.tv_homeTeamScore)
        private val awayTeam: TextView = view.findViewById(R.id.tv_awayTeamName)
        private val awayScore: TextView = view.findViewById(R.id.tv_awayTeamScore)
        private val playingDate: TextView = view.findViewById(R.id.tv_playingDate)

        fun bindEvents (events: Event, listener: (Event) -> Unit){
            homeTeam.text = events.homeTeamName
            homeScore.text = events.homeScore.toString()
            awayTeam.text = events.awayTeamName
            awayScore.text = events.awayScore.toString()
            playingDate.text = events.dateEvent

            itemView.onClick { listener(events) }


        }

    }

}