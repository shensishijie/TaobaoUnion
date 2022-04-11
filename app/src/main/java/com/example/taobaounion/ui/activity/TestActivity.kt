package com.example.taobaounion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taobaounion.R
import com.example.taobaounion.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private val binding: ActivityTestBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
