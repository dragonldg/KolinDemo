package com.douglas.kotlinone.jetpack.databinding

import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.douglas.kotlinone.R
import com.douglas.kotlinone.databinding.ActivityMainKotlinBinding

class MainActivityKotlin : AppCompatActivity() {
    private val user : UserKt = UserKt()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main_kotlin)
//        MainActivityKotlintyKotlin
        val binding:ActivityMainKotlinBinding = DataBindingUtil.setContentView<ActivityMainKotlinBinding>(this,R.layout.activity_main_kotlin)
        user.name.set("douglas")
        user.pwd.set("111111")
        binding.user = user

        Handler(mainLooper).postDelayed({
//            user.name.set("chris")
//            user.pwd.set("222222")
            println("name=${user.name.get()},pwd=${user.pwd.get()}")
        },8000)
    }
}