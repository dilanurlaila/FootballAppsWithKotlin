package id.co.metrasat.firtsappwithkotlin.presenter

import com.google.gson.Gson
import id.co.metrasat.firtsappwithkotlin.Helper.ApiRepository
import id.co.metrasat.firtsappwithkotlin.Helper.MainView
import id.co.metrasat.firtsappwithkotlin.Helper.TheSportDBApi
import id.co.metrasat.firtsappwithkotlin.Model.EventsResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun getEventNext(leagueId: String?) {
        view.showLoading()
        doAsync {
            val datas = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getEventNext(leagueId)),
                    EventsResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showEventList(datas.Events)
            }
        }
    }

    fun getPastEvent(leagueId: String?) {
        view.showLoading()
        doAsync {
            val datas = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getEventPast(leagueId)),
                    EventsResponse::class.java
            )
            uiThread {
                view.hideLoading()
                view.showEventList(datas.Events)
            }
        }
    }

}