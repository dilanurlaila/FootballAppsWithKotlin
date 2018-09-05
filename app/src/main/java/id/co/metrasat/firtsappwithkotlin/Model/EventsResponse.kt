package id.co.metrasat.firtsappwithkotlin.Model

import com.google.gson.annotations.SerializedName

data class EventsResponse(
        @SerializedName("events")
        val Events: List<EventsItem>
)