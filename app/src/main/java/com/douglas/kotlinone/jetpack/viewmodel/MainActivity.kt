package com.douglas.kotlinone.jetpack.viewmodel

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.douglas.kotlinone.R

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // 初始化ViewModel
        myViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[MyViewModel::class.java]

        val textView:TextView = findViewById(R.id.vm_text)
        textView.text = "${myViewModel.number}"
        findViewById<Button>(R.id.vm_btn).setOnClickListener {
            textView.text = "${++myViewModel.number}"
        }
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroy")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        println("configuration")
    }
}