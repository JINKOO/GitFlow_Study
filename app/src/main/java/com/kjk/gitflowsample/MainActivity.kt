package com.kjk.gitflowsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.kjk.gitflowsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = binding.tvName.text.toString()
        Log.w("1111", name)

        //TODO 이름을 토스트로 보여주는 버튼을 추가해야 한다.

    }

    // short branch에서 기능 개선(bug fix)
    private fun showToast(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
    }
}