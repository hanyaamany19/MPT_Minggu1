package com.example.utskotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PendudukAdapter (val pndukList: ArrayList<Penduduk>): RecyclerView.Adapter<PendudukAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.pnduk_list, parent, false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return pndukList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewName = itemView.findViewById(R.id.nama_penduduk) as TextView
        val textViewTtl = itemView.findViewById(R.id.ttl_penduduk) as TextView
        val textViewNomer = itemView.findViewById(R.id.hp_penduduk) as TextView
        val textViewAddress = itemView.findViewById(R.id.alamat_penduduk) as TextView
    }

    override fun onBindViewHolder(holder: PendudukAdapter.ViewHolder, position: Int) {
        val pnduk: Penduduk=pndukList[position]
        holder?.textViewName?.text = pnduk.name
        holder?.textViewTtl?.text = pnduk.ttl
        holder?.textViewNomer?.text = pnduk.nomer
        holder?.textViewAddress?.text = pnduk.address
    }

}