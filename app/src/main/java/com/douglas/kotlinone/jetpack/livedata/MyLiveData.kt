package com.douglas.kotlinone.jetpack.livedata

import androidx.lifecycle.MutableLiveData

object MyLiveData {
    val info1 : MutableLiveData<String> by lazy { MutableLiveData() }
}