package com.example.utskotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPndk.setOnClickListener {
            startActivity(Intent(this, PendudukActivity::class.java))
            finish()
        }

        btnRec.setOnClickListener {
            startActivity(Intent(this, RecylerActivity::class.java))
            finish()
        }

        button.setOnClickListener {
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
