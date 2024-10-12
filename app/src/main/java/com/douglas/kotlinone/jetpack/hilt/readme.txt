Dagger2
需要导入API、注解库和annotationProcessor库
    implementation("com.google.dagger:dagger:2.4")
    annotationProcessor("com.google.dagger:dagger-compiler:2.4")

原理：APT，编译期间生成代码
@Component(modules = [Module::class])
@Module
@Inject
@Singleton 单利，全局单利可以在Application种实现DaggerComponent注入
注意区分Java和Kotlin两种方式的注解处理器的引入方式的差异
    implementation("com.google.dagger:dagger:2.51.1")
    kapt("com.google.dagger:dagger-compiler:2.51.1") // kapt
    annotationProcessor("com.google.dagger:dagger-compiler:2.51.1") // java

Hilt Dagger2的二次封装