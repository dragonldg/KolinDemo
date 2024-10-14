package com.douglas.kotlinone.jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by liudagang on 2024/10/13.
 *
 * Package Name KotlinOne
 */
class MyViewModel : ViewModel() {
    var number:Int = 0

    val info:MutableLiveData<String> by lazy { MutableLiveData() }



}