package com.douglas.kotlinone.jetpack.hilt.dagger

import dagger.Module
import dagger.Provides
import javax.inject.Scope
import javax.inject.Singleton

// 用来提供对象
// 这里不用添加Singleton也可以使用
@Module
open class HttpModule {
    @Provides
    @Singleton // 这里添加Component也必须添加，否则会编译失败
    fun providerHttpObject():HttpObject {
      return HttpObject()
    }
}