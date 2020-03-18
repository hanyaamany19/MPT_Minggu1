package com.example.mpt_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter (val mhsList: ArrayList<Mahasiswa>): RecyclerView.Adapter<MahasiswaAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mhs: Mahasiswa=mhsList[position]
        holder?.textNama?.text = mhs.nama_mahasiswa
        holder?.textNIM?.text = mhs.nim_mahasiswa
        holder?.textAlamat?.text = mhs.alamat_mahasiswa
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.mhs_list, parent, false)
        return  ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return mhsList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textNama = itemView.findViewById(R.id.hnama) as TextView
        val textNIM = itemView.findViewById(R.id.hnim) as TextView
        val textAlamat = itemView.findViewById(R.id.halamat) as TextView
    }

}