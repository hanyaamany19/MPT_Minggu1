package com.example.mpt_8

import android.annotation.SuppressLint
import android.content.Context
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
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_mahasiswa.*
import kotlinx.android.synthetic.main.mhs_list.*
import org.json.JSONArray
import org.json.JSONObject

class MahasiswaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mahasiswa)

        getdariserver()

        btnTmbh.setOnClickListener(){
            val dt_nama: String = hnama.text.toString()
            val dt_nim: String = hnim.text.toString()
            val dt_almt: String = halamat.text.toString()
            postkeserve(dt_nama, dt_nim, dt_almt)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnKmbli.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@MahasiswaActivity,MainActivity::class.java))
            finish()
        }
    }

    @SuppressLint("WrongConstant")
    fun getdariserver(){
        val recyclerView = findViewById(R.id.recycleView) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val mhs=ArrayList<Mahasiswa>()

        AndroidNetworking.get("http://projekdatamahasiswa.000webhostapp.com/mhs_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("nama_mahasiswa"))

                        val isi1 = jsonObject.optString("nama_mahasiswa").toString()
                        val isi2 = jsonObject.optString("nim_mahasiswa").toString()
                        val isi3 = jsonObject.optString("alamat_mahasiswa").toString()

                        mhs.add(Mahasiswa("$isi1", "$isi2", "$isi3"))

                    }

                    val adapter = MahasiswaAdapter(mhs)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserve(data1:String, data2:String, data3:String){
        AndroidNetworking.post("http://projekdatamahasiswa.000webhostapp.com/dt_mhs.php")
            .addBodyParameter("nama_mahasiswa", data1)
            .addBodyParameter("nim_mahasiswa", data2)
            .addBodyParameter("alamat_mahasiswa", data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {

                }

                override fun onError(anError: ANError?) {

                }
            })
    }
}
