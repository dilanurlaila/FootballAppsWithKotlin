package id.co.metrasat.firtsappwithkotlin

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.FrameLayout
import id.co.metrasat.firtsappwithkotlin.fragment.fragmentEventNext
import id.co.metrasat.firtsappwithkotlin.fragment.fragmentEventPast

class Main2Activity : AppCompatActivity() {

    private var content: FrameLayout? = null
    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        content = findViewById<FrameLayout>(R.id.container)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        toolbar = supportActionBar!!
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = fragmentEventPast.Companion.newInstance()
        addFrgment(fragment)
        toolbar.title = "Previous Event Match"
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.prev_match -> {
                    val fragment = fragmentEventPast.Companion.newInstance()
                    addFrgment(fragment)
                    toolbar.title = "Previous Event Match"
                    return true
                }
                R.id.next_match -> {
                    val fragment = fragmentEventNext.Companion.newInstance()
                    addFrgment(fragment)
                    toolbar.title = "Next Event Match"
                    return true
                }

            }
            return false
        }
    }

    private fun addFrgment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.container, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }

}
