package id.co.metrasat.firtsappwithkotlin.Helper

import java.net.URL

class ApiRepository {
    fun doRequest(url: String): String {
        return  URL(url).readText()
    }
}