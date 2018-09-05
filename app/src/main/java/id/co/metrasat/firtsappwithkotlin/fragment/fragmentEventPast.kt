package id.co.metrasat.firtsappwithkotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.gson.Gson
import id.co.metrasat.firtsappwithkotlin.Adapter.EventsAdapter
import id.co.metrasat.firtsappwithkotlin.Helper.ApiRepository
import id.co.metrasat.firtsappwithkotlin.Helper.MainView
import id.co.metrasat.firtsappwithkotlin.Helper.TheSportDBApi.getEventPast
import id.co.metrasat.firtsappwithkotlin.Helper.invisible
import id.co.metrasat.firtsappwithkotlin.Helper.visible
import id.co.metrasat.firtsappwithkotlin.Model.EventsItem
import id.co.metrasat.firtsappwithkotlin.Model.TeamsItem
import id.co.metrasat.firtsappwithkotlin.R
import id.co.metrasat.firtsappwithkotlin.presenter.MainPresenter
import org.jetbrains.anko.support.v4.onRefresh


class fragmentEventPast : Fragment(), MainView {

    private var eventsNext: MutableList<EventsItem> = mutableListOf()
    private lateinit var presenter: MainPresenter
    private lateinit var mAdapter: EventsAdapter
    private lateinit var progresBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerViewEvent: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment

        val rootview = inflater.inflate(R.layout.fragment_event_past, container, false)

        progresBar = rootview.findViewById(R.id.pg_barEventPast)
        swipeRefresh = rootview.findViewById(R.id.swipe_rv_EventPast)
        recyclerViewEvent = rootview.findViewById(R.id.rv_eventPast)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 1)
        recyclerViewEvent.layoutManager = layoutManager
        mAdapter = EventsAdapter(context, eventsNext)
        recyclerViewEvent.adapter = mAdapter


        val apiRepository = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, apiRepository, gson)
        presenter.getPastEvent(MainView.LEAGUE_ID)
        println("prev====================" + getEventPast(MainView.LEAGUE_ID))

        swipeRefresh.onRefresh {
            presenter.getEventNext(MainView.LEAGUE_ID)
        }

        return rootview


    }

    companion object {

        @JvmStatic
        fun newInstance() =
                fragmentEventPast().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

    override fun showTeamList(data: List<TeamsItem>?) {

    }

    override fun showLoading() {

        progresBar.visible()
    }

    override fun hideLoading() {
        progresBar.invisible()
    }

    override fun showEventList(data: List<EventsItem>) {
        swipeRefresh.isRefreshing = false
        eventsNext.clear()
        eventsNext.addAll(data)
        mAdapter.notifyDataSetChanged()

    }
}
