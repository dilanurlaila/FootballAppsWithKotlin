package id.co.metrasat.firtsappwithkotlin.Helper

import id.co.metrasat.firtsappwithkotlin.Model.EventsItem
import id.co.metrasat.firtsappwithkotlin.Model.TeamsItem

interface MainView {
    fun showLoading()

    fun hideLoading()

    fun showEventList(data:List<EventsItem>)

    fun showTeamList (data: List<TeamsItem>?)

    companion object {
        val LEAGUE_ID = "4328"

    }
}