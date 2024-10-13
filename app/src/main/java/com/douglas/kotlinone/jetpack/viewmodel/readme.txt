viewmodel保证数据的稳定性;

旋转屏幕的生命周期
onPause -> onStop -> onDestroy -> onCreate -> onStart -> onResume

处理过后
android:configChanges="screenSize|orientation"
override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        println("configuration")
    }

