package com.example.minggupertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Handler
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    internal var pStatus = 0
    private val handler = Handler()
    internal lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val res = resources
        val drawable = res.getDrawable(R.drawable.circular)
        val mProgress = findViewById<View>(R.id.circularProgressbar) as ProgressBar
        mProgress.progress = 0
        mProgress.secondaryProgress = 100
        mProgress.max = 100
        mProgress.progressDrawable = drawable

        tv = findViewById<View>(R.id.tv) as TextView
        Thread(Runnable {
            // TODO Auto-generated method stub
            while (pStatus < 100) {
                pStatus += 1

                handler.post {
                    // TODO Auto-generated method stub
                    mProgress.progress = pStatus
                    tv.text = pStatus.toString() + "%"
                }
                try {
                    Thread.sleep(60)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }).start()
    }
}

