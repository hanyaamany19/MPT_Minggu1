package com.example.mpt_8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.user_list, parent, false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textUser = itemView.findViewById(R.id.husername) as TextView
        val textPass = itemView.findViewById(R.id.hpass) as TextView
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user: User=userList[position]
        holder?.textUser?.text = user.username
        holder?.textPass?.text = user.password
    }

}