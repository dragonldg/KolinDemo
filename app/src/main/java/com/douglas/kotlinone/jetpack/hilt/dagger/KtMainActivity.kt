package com.douglas.kotlinone.jetpack.hilt.dagger

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.douglas.kotlinone.R
import javax.inject.Inject

class KtMainActivity : AppCompatActivity() {
    @Inject
    lateinit var httpObject: HttpObject // kt版本必须是lateinit否则会爆出 private问题

    @Inject
    lateinit var httpObject2: HttpObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kt_main)
//
        DaggerHttpComponent.create().injectKtMainActivity(this@KtMainActivity)
        println("KT${httpObject.toString()}")
        println(httpObject2.toString())
        Toast.makeText(this,"object:${httpObject.hashCode()}",Toast.LENGTH_SHORT).show()
    }
}