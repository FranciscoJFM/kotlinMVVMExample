package com.example.kotlinmvvm.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.kotlinmvvm.databinding.ActivityMainBinding
import com.example.kotlinmvvm.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var  binding: ActivityMainBinding

    private val queoteViewModel  : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        queoteViewModel.onCreate()

        queoteViewModel.quoteModel.observe(this, Observer { currenquote ->
            binding.tvQuote.text = currenquote.quote
            binding.tvAuthor.text = currenquote.author
        })

        queoteViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })
        binding.btnToast.setOnClickListener{toast()}
        binding.viewContainer.setOnClickListener{queoteViewModel.randomQuote()}
    }

    private fun toast(){
        Toast.makeText(this,"Toast!",Toast.LENGTH_SHORT).show()
    }

}