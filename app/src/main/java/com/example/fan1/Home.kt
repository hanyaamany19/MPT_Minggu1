package com.example.fan1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnIdentitas.setOnClickListener {
            val intent1= Intent(this,IdentitasMasjid::class.java)
            startActivity(intent1)
        }

        btnJadwal.setOnClickListener {
            val intent2 = Intent(this,MainActivity::class.java)
            startActivity(intent2)
        }

        btnMarquee.setOnClickListener {
            val intent3 = Intent(this,Marguee::class.java)
            startActivity(intent3)
        }

        btnPengumuman.setOnClickListener {
            val intent4 = Intent(this,PengumumanMasjid::class.java)
            startActivity(intent4)
        }

        btnSlide.setOnClickListener {
            val intent5 = Intent(this,SlideActivity::class.java)
            startActivity(intent5)
        }

        btnTagline.setOnClickListener {
            val intent6 = Intent(this,Tagline::class.java)
            startActivity(intent6)
        }
    }
}
