package com.douglas.kotlinone.jetpack.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class AndViewModel(application: Application) : AndroidViewModel(application) {
     val phoneInfo by lazy { MutableLiveData<String>() }
     init {
         phoneInfo.value = ""
     }
     var context:Context = application

     fun appendNum(number: String){
          phoneInfo.value += number
     }
}