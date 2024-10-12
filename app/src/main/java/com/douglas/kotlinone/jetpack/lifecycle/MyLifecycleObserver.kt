package com.douglas.kotlinone.jetpack.lifecycle

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

//// 这个版本貌似不执行了
//class MyLifecycleObserver : LifecycleObserver {
//    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    fun onCreate() = { println("执行onCreate")}
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_START)
//    fun onStart()={ println("执行力onStart")}
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    fun onResume() = { println("执行onResume")}
//}


class MyLifecycleObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        println("执行oncreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        println("执行onResume")
    }

}