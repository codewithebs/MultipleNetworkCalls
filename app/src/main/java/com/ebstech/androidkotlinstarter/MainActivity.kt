package com.ebstech.androidkotlinstarter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ebstech.androidkotlinstarter.databinding.ActivityMainBinding
import com.ebstech.androidkotlinstarter.viewmodels.UserViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.name= "Ebeso Joseph"
        var  viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.age = viewModel
        binding.lifecycleOwner = this
    }


}