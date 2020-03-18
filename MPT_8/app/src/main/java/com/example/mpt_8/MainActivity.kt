package com.example.mpt_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMhs.setOnClickListener {
            startActivity(Intent(this@MainActivity,MahasiswaActivity::class.java))
            finish()
        }

        btnUser.setOnClickListener {
            startActivity(Intent(this@MainActivity,UserActivity::class.java))
            finish()
        }

        button.setOnClickListener {
            startActivity(Intent(this@MainActivity,LoginActivity::class.java))
            finish()
        }
    }
}
