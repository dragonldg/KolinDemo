package com.douglas.kotlinone

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// 一个挂起函数，模拟网络请求
suspend fun fetchData(): String {
    delay(1000) // 模拟延迟1秒的网络请求
    return "Data from the network"
}

fun main() = runBlocking {
    // 创建一个协程作用域
    val time = measureTimeMillis {
        val result = async { fetchData() } // 启动一个协程来执行网络请求
        println("Waiting for data...")
        println("Data received: ${result.await()}")
    }
    println("Time taken: $time ms")
}