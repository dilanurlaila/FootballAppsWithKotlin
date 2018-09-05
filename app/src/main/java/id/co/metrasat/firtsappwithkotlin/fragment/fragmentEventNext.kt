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
import id.co.metrasat.firtsappwithkotlin.Helper.TheSportDBApi.getEventNext
import id.co.metrasat.firtsappwithkotlin.Helper.invisible
import id.co.metrasat.firtsappwithkotlin.Helper.visible
import id.co.metrasat.firtsappwithkotlin.Model.EventsItem
import id.co.metrasat.firtsappwithkotlin.Model.TeamsItem
import id.co.metrasat.firtsappwithkotlin.R
import id.co.metrasat.firtsappwithkotlin.presenter.MainPresenter


class fragmentEventNext : Fragment(), MainView {

    private var eventsNext: MutableList<EventsItem> = mutableListOf()

    private lateinit var presenter: MainPresenter
    private lateinit var mAdapter: EventsAdapter
    private lateinit var progresBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerViewEvent: RecyclerView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.fragment_event_next, container, false)
        progresBar = rootview.findViewById(R.id.pg_barEventNext)
        swipeRefresh = rootview.findViewById(R.id.swipe_rv_EventNext)
        recyclerViewEvent = rootview.findViewById(R.id.rv_eventNext)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 1)
        recyclerViewEvent.layoutManager = layoutManager
        mAdapter = EventsAdapter(this.requireActivity(), eventsNext)
        recyclerViewEvent.adapter = mAdapter


        val apiRepository = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this, apiRepository, gson)

        presenter.getEventNext(MainView.LEAGUE_ID)

        println("next==============" + getEventNext(MainView.LEAGUE_ID))

        return rootview
    }

    companion object {

        @JvmStatic
        fun newInstance() =
                fragmentEventNext().apply {
                    arguments = Bundle().apply {

                    }
                }
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

    override fun showTeamList(data: List<TeamsItem>?) {
    }
}
