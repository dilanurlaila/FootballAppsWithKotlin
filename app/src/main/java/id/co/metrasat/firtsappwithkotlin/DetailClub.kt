package id.co.metrasat.firtsappwithkotlin

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity() {

    var title: String = ""
    var Image: Int = 0
    var desc: String = ""

    lateinit var txt_title: TextView
    lateinit var img_logo: ImageView
    lateinit var txt_desc: TextView

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = getIntent()

        verticalLayout {
            padding = dip(16)
            gravity = Gravity.CENTER


            img_logo = imageView(R.drawable.img_acm) {
                bottomPadding = dip(5)
            }.lparams(width = dip(150), height = dip(150))

            txt_title = textView() {
                textSize = 20f
                topPadding = dip(10)
                bottomPadding = dip(15)
                gravity = Gravity.CENTER
            }.lparams(width = wrapContent)

            txt_desc = textView() {
                textSize = 15f
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams(width = matchParent)
        }

        title = intent.getStringExtra("title")
        Image = intent.getIntExtra("images", 0)
        desc = intent.getStringExtra("desc")

        txt_title.text = title
        Glide.with(img_logo).load(Image).into(img_logo)
        txt_desc.text = desc

    }
}

