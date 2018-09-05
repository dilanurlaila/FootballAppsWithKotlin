package id.co.metrasat.firtsappwithkotlin.presenter

import com.google.gson.Gson
import id.co.metrasat.firtsappwithkotlin.Helper.ApiRepository
import id.co.metrasat.firtsappwithkotlin.Helper.MainView
import id.co.metrasat.firtsappwithkotlin.Helper.TheSportDBApi
import id.co.metrasat.firtsappwithkotlin.Model.EventsResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventDetailsPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getLookUpEvents(eventId: String?){
        view.showLoading()
        doAsync {
            val datas = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getLookUpEvent(eventId)),
                    EventsResponse::class.java
            )
            uiThread {
                view.showEventList(datas.Events)
                view.hideLoading()
            }
        }
    }

}

