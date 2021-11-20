package com.kjk.gitflowsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kjk.gitflowsample.data.Model
import com.kjk.gitflowsample.databinding.ActivityMainBinding
import com.kjk.gitflowsample.view.RecyclerViewAdapter

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter: RecyclerViewAdapter by lazy {
        RecyclerViewAdapter(model)
    }

    private val model = Model()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayoutValues()
        setListener()
    }


    private fun initLayoutValues() {
        setContentView(binding.root)

        //TODO 리사이클러 뷰를 초기화해야한다.
        binding.apply {
            rvContents.addItemDecoration(DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL))
            rvContents.layoutManager = createLayoutManager()
            rvContents.adapter = adapter
        }
    }

    private fun createLayoutManager(): LinearLayoutManager {
        var layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        return layoutManager
    }

    private fun setListener() {
        binding.btnInput.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.btnInput -> {
                onClickInputButton()
            }
        }
    }

    private fun onClickInputButton() {
        model.createTestData()
        adapter.notifyDataSetChanged()
    }
}