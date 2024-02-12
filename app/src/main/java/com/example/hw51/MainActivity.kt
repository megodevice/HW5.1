package com.example.hw51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw51.data.Injector
import com.example.hw51.data.SimpleCounter
import com.example.hw51.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SimpleCounter {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        binding.btDec.setOnClickListener { presenter.dec() }
        binding.btInc.setOnClickListener { presenter.inc() }
    }

    override fun showCount(count: Int) {
        binding.tvCount.text = count.toString()
    }

    override fun changeTextSize(textSize: Float) {
        binding.tvCount.textSize = textSize
    }

    override fun changeTextColor(color: Int) {
        binding.tvCount.setTextColor(color)
    }

    override fun showToast() {
        Toast.makeText(this, resources.getText(R.string.toast_text), Toast.LENGTH_SHORT).show()
    }

    override fun setVisibilityButton(visibility: Int) {
        binding.btDec.visibility = visibility
    }
}