viewmodel保证数据的稳定性;

旋转屏幕的生命周期
onPause -> onStop -> onDestroy -> onCreate -> onStart -> onResume

处理过后
android:configChanges="screenSize|orientation"
override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        println("configuration")
    }


关键点：ViewModelStore.java  包含put,get,clear
即：activity保存了一个mMap
HashMap<String ,ViewModel> mMap = new HashMap<>()

Factory：包含create，通过反射创建ViewModel


onRetainCustomNonConfigurationInstance() //Activity的方法，需要重写
NonConfigurationInstances nc = new NonConfigurationInstances();
nc.viewModelStore = viewModelStore;
nc.custom = onRetainCustomNonConfigurationInstance()的结果

@ComponentActivity.java
有个lifecycle.addObserver()的监听；
只有OnDestroy才会移除ViewModel保存的数据；
里面有个条件：isChangingConfigurations() // 是否为切换屏幕，如果不是切换屏幕就清除

