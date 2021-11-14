package com.kjk.gitflowsample.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjk.gitflowsample.data.Model

class RecyclerViewAdapter(val model: Model): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return model.getitemList().size
    }


}