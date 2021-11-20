package com.kjk.gitflowsample.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kjk.gitflowsample.data.Model
import com.kjk.gitflowsample.databinding.ItemRowBinding

class RecyclerViewAdapter(private val model: Model): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val notifyChangedCallBack: AdapterNotify by lazy {
        object : AdapterNotify {
            override fun notifyDataChanged(pos: Int) {
                if (pos < 0) {
                    notifyDataSetChanged()
                } else {
                    notifyItemChanged(pos)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(
            binding,
            model,
            notifyChangedCallBack
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind()
        }
    }

    override fun getItemCount(): Int {
        return model.getItemList().size
    }


    class ItemViewHolder(
        private val binding: ItemRowBinding,
        private val model: Model,
        private val adapterNotify: AdapterNotify
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            setListener()
        }

        private fun setListener() {
            binding.tvContents.setOnClickListener(this)
        }

        fun bind() {
            binding.tvContents.text = model.getItemContents(adapterPosition)
        }

        override fun onClick(v: View?) {
            when(v) {
                binding.tvContents -> {
                    dataChangeFunc()
                }
            }
        }

        private fun dataChangeFunc() {
            Log.w("1111", "${adapterPosition.toString()}")
            model.getItemContents(adapterPosition)
            Log.w("1111","${model.getItemContents(adapterPosition)}")
            model.updateContents(adapterPosition)
            adapterNotify.notifyDataChanged(adapterPosition)
        }
    }

}