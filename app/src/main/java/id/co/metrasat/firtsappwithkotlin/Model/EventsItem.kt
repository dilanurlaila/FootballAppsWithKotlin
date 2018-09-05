package id.co.metrasat.firtsappwithkotlin.Model

import com.google.gson.annotations.SerializedName


data class EventsItem(
        @SerializedName("idEvent")
        var idEvent: String?,

        @SerializedName("idLeague")
        val idLeague: String?,

        @SerializedName("idAwayTeam")
        var idAwayTeam: String?,

        @SerializedName("intHomeScore")
        val intHomeScore: String?,

        @SerializedName("idHomeTeam")
        var idHomeTeam: String?,

        @SerializedName("intAwayScore")
        val intAwayScore: String?,

        @SerializedName("dateEvent")
        val dateEvent: String?,

        @SerializedName("strAwayTeam")
        val strAwayTeam: String?,

        @SerializedName("strHomeTeam")
        val strHomeTeam: String?,

        @SerializedName("strHomeLineupDefense")
        val strHomeLineupDefense: String?,

        @SerializedName("strAwayLineupDefense")
        val strAwayLineupDefense: String?,

        @SerializedName("strHomeLineupForward")
        val strHomeLineupForward: String?,

        @SerializedName("strHomeLineupSubstitutes")
        val strHomeLineupSubtitutes: String?,

        @SerializedName("strAwayLineupForward")
        val strAwayLineupForward: String?,

        @SerializedName("strAwayLineupSubstitutes")
        val strAwayLineupSubtitutes: String?,

        @SerializedName("strAwayLineupMidfield")
        val strAwayLineupMidfield: String?,

        @SerializedName("strHomeLineupMidfield")
        val strHomeLineupMidfield: String?,

        @SerializedName("strHomeGoalDetails")
        val strHomeGoalDetails: String?,

        @SerializedName("strAwayGoalDetails")
        val strAwayGoalsDetails: String?,

        @SerializedName("strAwayFormation")
        val strAwayFormation: String?,

        @SerializedName("strHomeFormation")
        val strHomeFormation: String?

)