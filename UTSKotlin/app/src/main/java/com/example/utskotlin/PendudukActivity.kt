package com.example.utskotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_penduduk.*
import kotlinx.android.synthetic.main.pnduk_list.*
import org.json.JSONArray

class PendudukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penduduk)

        btnTmbh.setOnClickListener(){
            val data_namapenduduk :String = textnama.text.toString()
            val data_ttlpenduduk :String = textttl.text.toString()
            val data_hppenduduk :String = texthp.text.toString()
            val data_alamatpenduduk:String = textalamat.text.toString()
            postkeserve(data_namapenduduk, data_ttlpenduduk, data_hppenduduk, data_alamatpenduduk)

//            textnama.setText("")
//            textttl.setText("")
//            texthp.setText("")
//            textalamat.setText("")
//
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnKmbli1.setOnClickListener{
//            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
//            val editor=sharedPreferences.edit()
//
//            editor.putString("STATUS","0")
//            editor.apply()

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    fun postkeserve(nama:String, ttl:String, hp:String, alamat:String){
        AndroidNetworking.post("https://dtpenduduk.000webhostapp.com/pros_penduk.php")
            .addBodyParameter("nama_penduduk", nama)
            .addBodyParameter("ttl_penduduk", ttl)
            .addBodyParameter("hp_penduduk", hp)
            .addBodyParameter("alamat_penduduk", alamat)
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
