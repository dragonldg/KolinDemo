LiveData 一般需要配合 ViewModel 使用
即使观察者也是被观察者
原理：
借助lifecycle实现生命周期的监听，只有started和resumed的状态才会接收数据；
发送数据最后会通过回调的方式响应，postValue会经过handler处理最后仍然是setValue；


粘性产生的原因：发送数据会导致mVersion加1，mLastVersion会小于mVersion导致数据仍然有发送；
修改Livedata的粘性问题，优先调用父类的observer，但是没有观察者，所以dispatchValue种的for循环进不去，估不会执行considerNotify
等到添加了观察者后会再次执行，此时observe-> new LifecycleBoundObserver()->onStateChanged()->
activeStateChanged(true)->dispatchValue(this)->considerNotify(initiator)

注意：因为观察者是在onCreate中观察的，此时mActive==false,只有start和resume才是true；估上面先调用super.observer只是注册
了观察者，并没有去分发数据的操作，在activeStateChanged(false)中时，mActive==false,导致dispatchingValue无法执行
等到start或者resume后，会回调到activeStateChanged(true),mActive==true；
关键是onCreate中已经对mLastVersion==mVersion进行了处理，所以等到onStart时，不会再次分发数据了，如果注册观察者放在onStart
或者onResume中，老师的反射方式去除粘性的操作将会失效；