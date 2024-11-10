package com.amrhishammahmoud.aroundworld.activities

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.amrhishammahmoud.aroundworld.R
import com.amrhishammahmoud.aroundworld.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


    }


    override fun onResume() {
        super.onResume()
        //To Add ToolBar(in ActionBar) for all fragments with appBarConfiguration
        setSupportActionBar(binding.toolbar)
        binding.apply {
            toolbar.title = ""
            toolbar.setTitleTextColor(Color.WHITE)
        }

    }
}