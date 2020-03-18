package com.example.utskotlin

import android.annotation.SuppressLint
import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_recyler.*
import org.json.JSONObject

class RecylerActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyler)

        btnKmbli.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users=ArrayList<Penduduk>()

        AndroidNetworking.get("http://dtpenduduk.000webhostapp.com/penduduk.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_penduduk"))

                        val isi1 = jsonObject.optString("nama_penduduk").toString()
                        val isi2 = jsonObject.optString("ttl_penduduk").toString()
                        val isi3 = jsonObject.optString("hp_penduduk").toString()
                        val isi4 = jsonObject.optString("alamat_penduduk").toString()

                        users.add(Penduduk("$isi1", "$isi2", "$isi3", "$isi4"))

                    }

                    val adapter = PendudukAdapter(users)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }
}
