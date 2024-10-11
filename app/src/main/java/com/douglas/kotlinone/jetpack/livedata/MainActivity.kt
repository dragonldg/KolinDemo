package com.douglas.kotlinone.jetpack.livedata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.douglas.kotlinone.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.text_livedata)


        // 粘性数据
        // 先修改数据，后观察数据，结果仍然能收到修改后的数据
        // observer.mLastVersion（观察者 ） < this.mVersion(被观察者) 初始值都是-1
        // 去除粘性：反射让mLastVersion == mVersion
        // 粘性数据只会保留最后一个
        MyLiveData.info1.observe(this) { // it 表示 onChanged的值
            text.text = it // 数据改变后页面会响应的修改
        }
        MyLiveData.info1.value = "defalut" // 只能在主线程

        // owner.lifecycle.addObserver(wrapper) // 绑定被观察者和观察者（wrapper）


        // MyLiveData1和MyService 模拟微信更新消息
//        startService(Intent(this,MyService::class.java))
//        Toast.makeText(this,"服务启动成功",Toast.LENGTH_SHORT).show()
//
//        MyLiveData1.info1.observe(this){
//            text.text = MyLiveData1.info1.value
//        }

        // MyLiveData
//        // 观察者
//        MyLiveData.info1.observe(this) { // it 表示 onChanged的值
//            text.text = it // 数据改变后页面会响应的修改
//        }
//
////        MyLiveData.info1.observe(this,object : Observer<String>{
////            override fun onChanged(value: String) {
////
////            }
////        })
//
//        // 触发数据改变
//        MyLiveData.info1.value = "defalut" // 只能在主线程
//
//        thread {
//            Thread.sleep(3000)
//            MyLiveData.info1.postValue("三秒后执行") // 可以在子线程
//        }
//
//        thread {
//            Thread.sleep(6000)
//            MyLiveData.info1.postValue("6秒后执行")
//        }
    }
}