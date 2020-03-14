package com.example.slideshow

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val slides=ArrayList<SlideShow>()

        AndroidNetworking.get("https://menumasjidmahasiswa.000webhostapp.com/slide_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("judul_slideshow"))

                        val isi1 = jsonObject.optString("judul_slideshow").toString()
                        val isi2 = jsonObject.optString("url_slideshow").toString()

                        slides.add(SlideShow("$isi1", "$isi2"))

                    }

                    val adapter = CustomAdapter(slides)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
