package id.co.metrasat.firtsappwithkotlin

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import com.google.gson.Gson
import id.co.metrasat.firtsappwithkotlin.Helper.ApiRepository
import id.co.metrasat.firtsappwithkotlin.Helper.MainView
import id.co.metrasat.firtsappwithkotlin.Helper.TheSportDBApi.getLookUpEvent
import id.co.metrasat.firtsappwithkotlin.Helper.invisible
import id.co.metrasat.firtsappwithkotlin.Helper.visible
import id.co.metrasat.firtsappwithkotlin.Model.EventsItem
import id.co.metrasat.firtsappwithkotlin.Model.TeamsItem
import id.co.metrasat.firtsappwithkotlin.presenter.BadgeFetcher
import id.co.metrasat.firtsappwithkotlin.presenter.EventDetailsPresenter
import kotlinx.android.synthetic.main.detail_activity.*

class DetailClub : AppCompatActivity(), MainView {

    var idEvent: String = ""
    var idAway: String = ""
    var idHome: String = ""
    var nameHome: String = ""
    var nameAway: String = ""

    private lateinit var progresBar: ProgressBar
    private lateinit var presenter: EventDetailsPresenter
    private lateinit var events: EventsItem

    companion object {
        const val ID_EVENTS = "id_events"
        const val ID_AWAY = "id_Away"
        const val ID_HOME = "id_Home"
        const val HOME_NAME = "home_name"
        const val AWAY_NAME = "away_home"
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        progresBar = findViewById(R.id.pg_bar)

        val intent = intent
        idEvent = intent.getStringExtra(ID_EVENTS)
        idAway = intent.getStringExtra(ID_AWAY)
        idHome = intent.getStringExtra(ID_HOME)
        nameAway = intent.getStringExtra(AWAY_NAME)
        nameHome = intent.getStringExtra(HOME_NAME)

        val request = ApiRepository()
        val gson = Gson()
        presenter = EventDetailsPresenter(this, request, gson)
        presenter.getLookUpEvents(idEvent)

        println("=====================" + getLookUpEvent(idEvent))

        BadgeFetcher().loadLogo(idHome, img_home)
        BadgeFetcher().loadLogo(idAway, img_away)
    }

    override fun hideLoading() {
        progresBar.invisible()
    }

    override fun showEventList(data: List<EventsItem>) {
        events = data[0]
        txt_home_name_club.text = nameHome
        txt_away_name_club.text = nameAway

        txt_home_goals.text = events.strHomeGoalDetails?.replace(";", "\n")
        txt_away_goals.text = events.strAwayGoalsDetails?.replace(";", "\n")

        if (events.intHomeScore != null) txt_home_shots.text = events.intHomeScore.toString()
        if (events.intAwayScore != null) txt_away_shots.text = events.intAwayScore.toString()

        txt_home_defense.text = events.strHomeLineupDefense?.replace(";", "\n")
        txt_away_defense.text = events.strAwayLineupDefense?.replace(";", "\n")

        txt_home_formation.text = events.strHomeFormation?.replace(";", "\n")
        txt_away_formation.text = events.strAwayFormation?.replace(";", "\n")

        txt_home_midfield.text = events.strHomeLineupMidfield
        txt_away_midfield.text = events.strAwayLineupMidfield

        txt_away_subtitutes.text = events.strAwayLineupSubtitutes
        txt_home_substitutes.text = events.strHomeLineupSubtitutes

        txt_away_forward.text = events.strAwayLineupForward
        txt_home_forward.text = events.strHomeLineupForward


    }

    override fun showLoading() {
        progresBar.visible()

    }

    override fun showTeamList(data: List<TeamsItem>?) {

    }
}

