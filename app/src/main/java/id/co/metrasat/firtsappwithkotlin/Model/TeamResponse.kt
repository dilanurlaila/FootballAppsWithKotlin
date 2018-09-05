package id.co.metrasat.firtsappwithkotlin.Model
import com.google.gson.annotations.SerializedName


data class TeamResponse(@SerializedName("teams")
                val teams: List<TeamsItem>?)