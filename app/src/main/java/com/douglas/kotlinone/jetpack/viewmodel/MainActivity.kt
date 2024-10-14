package com.douglas.kotlinone.jetpack.viewmodel

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.douglas.kotlinone.R
import com.douglas.kotlinone.databinding.ActivityMain3Binding

class MainActivity : AppCompatActivity() {

    private lateinit var myViewModel: MyViewModel
    lateinit var andViewModel: AndViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main3)
        val binding:ActivityMain3Binding = DataBindingUtil.setContentView(this,R.layout.activity_main3)
        // 初始化ViewModel
        // [MyViewModel::class.java]表示通过反射创建ViewModel类的实例
        myViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[MyViewModel::class.java]

        // AndroidViewModelFactory 需要添加构造函数的参数
        andViewModel = ViewModelProvider(viewModelStore,ViewModelProvider.AndroidViewModelFactory(application))[AndViewModel::class.java]
        binding.vm = andViewModel

        // 需要一个解释
        binding.lifecycleOwner = this

        binding.vmText.text = "${andViewModel.phoneInfo}}"
        binding.vmBtn.setOnClickListener {
            binding.vmText.text = "${andViewModel.phoneInfo}"
        }

//        val textView:TextView = findViewById(R.id.vm_text)
//        textView.text = "${myViewModel.number}"
//        findViewById<Button>(R.id.vm_btn).setOnClickListener {
//            textView.text = "${++myViewModel.number}"
//        }
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