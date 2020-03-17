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
import kotlinx.android.synthetic.main.activity_mahasiswa.btnKmbli
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.mhs_list.*
import org.json.JSONArray
import org.json.JSONObject

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        getdariserver()

        btnTmbh1.setOnClickListener(){
            val dt_user: String = hnama.text.toString()
            val dt_pass: String = hnim.text.toString()
            postkeserve(dt_user, dt_pass)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnKmbli1.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@UserActivity,MainActivity::class.java))
            finish()
        }
    }

    @SuppressLint("WrongConstant")
    fun getdariserver(){
        val recyclerView = findViewById(R.id.recycleView1) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val users=ArrayList<User>()

        AndroidNetworking.get("http://projekdatamahasiswa.000webhostapp.com/user.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {
                    Log.e("_kotlinResponse", response.toString())

                    val jsonArray = response.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle", jsonObject.optString("usernamea"))

                        val isi1 = jsonObject.optString("username").toString()
                        val isi2 = jsonObject.optString("password").toString()

                        users.add(User("$isi1", "$isi2"))

                    }

                    val adapter = UserAdapter(users)
                    recyclerView.adapter= adapter
                }

                override fun onError(anError: ANError?) {
                    Log.i("_err", anError.toString())
                }
            })
    }

    fun postkeserve(data1:String, data2:String){
        AndroidNetworking.post("http://projekdatamahasiswa.000webhostapp.com/dtuser.php")
            .addBodyParameter("username", data1)
            .addBodyParameter("password", data2)
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
