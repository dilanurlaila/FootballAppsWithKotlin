package id.co.metrasat.firtsappwithkotlin.Adapter

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.co.metrasat.firtsappwithkotlin.DetailClub
import id.co.metrasat.firtsappwithkotlin.Model.EventsItem
import id.co.metrasat.firtsappwithkotlin.R
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class EventsAdapter(private val context: Context?, private val events: List<EventsItem>)
    : RecyclerView.Adapter<EventsAdapter.EventHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EventHolder(LayoutInflater.from(context).inflate(R.layout.card_list, parent, false))


    override fun getItemCount(): Int = events.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bindItem(events [position])
        holder.itemView.setOnClickListener {
            context?.startActivity<DetailClub>(DetailClub.ID_EVENTS to events[position].idEvent, DetailClub.ID_HOME to events[position].idHomeTeam,
                    DetailClub.ID_AWAY to events[position].idAwayTeam, DetailClub.AWAY_NAME to events[position].strAwayTeam, DetailClub.HOME_NAME to events[position].strHomeTeam)
        }

    }

    class EventHolder(view:View) :RecyclerView.ViewHolder(view) {
        private val tanggal = view.findViewById<TextView>(R.id.tgl_match)
        private val strAway = view.findViewById<TextView>(R.id.strAwayTeam)
        private val awayScore = view.findViewById<TextView>(R.id.strAwayScore)
        private val strHome = view.findViewById<TextView>(R.id.strHomeTeam)
        private val homeScore = view.findViewById<TextView>(R.id.strHomeScore)

        @RequiresApi(Build.VERSION_CODES.O)
        fun bindItem (events: EventsItem){
            val formatDate = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
            val date = formatDate.parse(events.dateEvent)
            val dateText = SimpleDateFormat("EEEE, dd-MM-yyyy", Locale.getDefault())
                    .format(date).toString()
            tanggal.text = dateText
            strAway.text = events.strAwayTeam
            strHome.text = events.strHomeTeam
            homeScore.text = events.intHomeScore
            awayScore.text = events.intAwayScore

        }
    }
}
