package com.douglas.kotlinone.jetpack.livedata

import androidx.lifecycle.MutableLiveData

object MyLiveData1 {
    val info1:MutableLiveData<String> by lazy { MutableLiveData() }
}