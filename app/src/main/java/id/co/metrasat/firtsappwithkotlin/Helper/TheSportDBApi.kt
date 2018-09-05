package id.co.metrasat.firtsappwithkotlin.Helper

import id.co.metrasat.firtsappwithkotlin.BuildConfig

object TheSportDBApi {

    fun getEventNext(league: String?): String {
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventsnextleague.php?id=" + league
    }

    fun getEventPast(leagueId: String?): String {
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/eventspastleague.php?id=" + leagueId
    }

    fun getLookupTeam(idTeam: String?): String {
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupteam.php?id=" + idTeam
    }

    fun getLookUpEvent(eventId: String?): String {
        return "${BuildConfig.BASE_URL}api/v1/json/${BuildConfig.TSDB_API_KEY}/lookupevent.php?id=" + eventId
    }
}