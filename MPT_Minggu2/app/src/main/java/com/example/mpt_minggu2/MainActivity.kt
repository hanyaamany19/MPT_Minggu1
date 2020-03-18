package com.example.mpt_minggu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumlah.setOnClickListener {
            var bilangan1: String = bil1.text.toString()
            var bilangan2: String = bil2.text.toString()

            var a: Int = bilangan1.toInt()
            var b: Int = bilangan2.toInt()

            var c:Int = a+b

            hasil.setText("$c")
        }

        kurang.setOnClickListener {
            var bilangan1: String = bil1.text.toString()
            var bilangan2: String = bil2.text.toString()

            var a: Int = bilangan1.toInt()
            var b: Int = bilangan2.toInt()

            var c:Int = a-b

            hasil.setText("$c")
        }

        kali.setOnClickListener {
            var bilangan1: String = bil1.text.toString()
            var bilangan2: String = bil2.text.toString()

            var a: Int = bilangan1.toInt()
            var b: Int = bilangan2.toInt()

            var c:Int = a*b

            hasil.setText("$c")
        }

        bagi.setOnClickListener {
            var bilangan1: String = bil1.text.toString()
            var bilangan2: String = bil2.text.toString()

            var a: Int = bilangan1.toInt()
            var b: Int = bilangan2.toInt()

            var c:Int = a/b

            hasil.setText("$c")
        }
    }
}
