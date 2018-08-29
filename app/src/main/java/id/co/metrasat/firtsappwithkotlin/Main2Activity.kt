package id.co.metrasat.firtsappwithkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class Main2Activity : AppCompatActivity() {

    private var item: MutableList<items> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val list = findViewById<RecyclerView>(R.id.rv_club)

        initData()

        list.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        list.adapter = ClubAdapter(this, item){

            onItemClickListener(it)
//            val intent = getIntent()
//            val names = intent.getStringExtra("names")
//            Toast.makeText(applicationContext, names + " anda memilih " + it.name, Toast.LENGTH_LONG).show()

        }

    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.description)
        item.clear()
        for (i in name.indices){
            item.add(items(name[i], image.getResourceId(i,0), desc[i]))
        }
        image.recycle()
    }

    private fun onItemClickListener (item: items){
        val intent = Intent(this, DetailClub::class.java)
        intent.putExtra("title", item.name)
        intent.putExtra("images", item.Image)
        intent.putExtra("desc", item.Description)
        startActivity(intent)
    }



}
