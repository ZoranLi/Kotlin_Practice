package com.example.myapplication.module.collect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Student

class CollectAdapter : RecyclerView.Adapter<CollectAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvID: TextView = itemView.findViewById(R.id.tv_id)
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvAge: TextView = itemView.findViewById(R.id.tv_age)
    }


    var allStudents: List<Student> = ArrayList();//


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.item_collect_list, parent, false)
        return MyViewHolder(itemView);
    }

    override fun getItemCount(): Int {
        return allStudents.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student: Student = allStudents[position]
        holder.tvID.text = "${position + 1}"
        holder.tvName.text = student.name
        holder.tvAge.text = "${student.age}"
    }

}
