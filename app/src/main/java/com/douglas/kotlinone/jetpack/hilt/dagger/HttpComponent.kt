package com.douglas.kotlinone.jetpack.hilt.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HttpModule::class])
interface HttpComponent { // 必须是接口
    fun injectMainActivity(activity: DaggerMainActivity)
    fun injectKtMainActivity(activity: KtMainActivity)
}