package com.example.animationmask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context:Context,private val list:Array<Int>,private val random:Int) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val textView=itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.model_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount()=96

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     if (position in list) {
         holder.textView.setBackgroundColor(ContextCompat.getColor(context,R.color.gold))
     }
        if (random!=0 && position % random==0) {
            holder.textView.text="★"
        }
    }

}
