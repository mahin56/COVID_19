package com.android.covid_19.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.covid_19.R
import com.android.covid_19.model.COVIDcases
import com.google.android.material.textview.MaterialTextView

class COVID_adapter : RecyclerView.Adapter<COVID_adapter.Viewholder>(){

  var list:List<COVIDcases> =ArrayList()
    fun setCOVIDcases(COVIDCases:List<COVIDcases>){
        this.list=COVIDCases
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
   val view:View=LayoutInflater.from(parent.context)
       .inflate(R.layout.covid_rv_itom,parent,false)
        return COVID_adapter.Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
      val COVIDcase:COVIDcases=list.get(position)
        holder.cases.text=COVIDcase.cases.toString()
        holder.status.text=COVIDcase.status
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class Viewholder(itemView: View) :RecyclerView.ViewHolder(itemView){
        lateinit var cases:MaterialTextView
        lateinit var status:MaterialTextView
        init {
            cases =itemView.findViewById(R.id.tex_v)
            status =itemView.findViewById(R.id.tex_v2)
        }
    }
}