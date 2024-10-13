Event事件驱动State状态

@ComponentActivity onCreate()中
ReportFragment.injectIfNeededIn(this) // 空白fragment

if (Build.VERSION.SDK_INT >= 29) {
                // On API 29+, we can register for the correct Lifecycle callbacks directly
                LifecycleCallbacks.registerIn(activity)
            }
@ReportFragment
activity.registerActivityLifecycleCallbacks(LifecycleCallbacks())


小于29的
@FragmentActivity onCreate()

mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE); // 根据事件将状态移动到相应位置
mFragments.dispatchCreate();

@FragmentStore
mFragmentStore.moveToExpectedState();

@FragmentStore
void moveToExpectedState()

@FragmentStateMananger
void moveToExpectedState() {}