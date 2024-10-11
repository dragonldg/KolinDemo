package com.douglas.kotlinone.jetpack.livedata

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlin.concurrent.thread

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread {
            for (x in 1..100000){
                MyLiveData1.info1.postValue("发送了消息，内容为：${x}")
                Thread.sleep(5000)
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}