package id.co.metrasat.firtsappwithkotlin.presenter

import android.widget.ImageView
import com.google.gson.Gson
import id.co.metrasat.firtsappwithkotlin.Helper.ApiRepository

class BadgeFetcher {
    private lateinit var presenter : BadgePresenter
    private lateinit var image : ImageView
    val apiRepository = ApiRepository()


    fun loadLogo (id: String, img:ImageView){
        img.setImageDrawable(null)
        val gson = Gson()
        presenter = BadgePresenter(img, apiRepository, gson)
        presenter.getLogo(id)
    }
}