package id.co.metrasat.firtsappwithkotlin

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val passwords = "hallo"

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)

        btn_Click.setOnClickListener(this)

        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_Click) {
            val nama = field_nama.text.toString()
            val password = field_password.text.toString()
            if (password == passwords) {

                startActivity(intentFor<Main2Activity>("names" to nama))

                Toast.makeText(this, "Hallo $nama, Selamat belajar Kotlin ", Toast.LENGTH_LONG).show()
            } else {
                val vibrate = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrate.vibrate(500)
                Toast.makeText(this, "Salah password", Toast.LENGTH_LONG).show();
            }
            println("hasilnya =======" + password == passwords)

        }

    }

}

