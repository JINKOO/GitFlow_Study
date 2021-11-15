package com.kjk.gitflowsample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kjk.gitflowsample.data.Model
import com.kjk.gitflowsample.databinding.ItemRowBinding

class RecyclerViewAdapter(val model: Model): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


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
    }

    override fun getItemCount(): Int {
        return model.getitemList().size
    }


    class ItemViewHolder(
        val binding: ItemRowBinding,
        val model: Model,
        val adapterNotify: AdapterNotify
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            setListener()
        }

        private fun setListener() {
            binding.tvContents.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            when(v) {
                binding.tvContents -> {
                    dataChangeFunc()
                }
            }
        }

        private fun dataChangeFunc() {
            model.getItemContents(adapterPosition)
            adapterNotify.notifyDataChanged(adapterPosition)
        }
    }

}