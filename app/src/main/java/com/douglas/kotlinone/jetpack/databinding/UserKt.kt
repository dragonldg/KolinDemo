package com.douglas.kotlinone.jetpack.databinding

import androidx.databinding.ObservableField

/**
 * Created by liudagang on 2024/10/13.
 *
 * Package Name KotlinOne
 */
class UserKt {
//    var name:String?= null
//
//    var pwd:String ? = null

    // Observable必须使用set和get
    val name:ObservableField<String> by lazy { ObservableField<String>() }

    val pwd:ObservableField<String> by lazy { ObservableField<String>() }

}
