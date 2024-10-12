Dagger2
需要导入API、注解库和annotationProcessor库
    implementation("com.google.dagger:dagger:2.4")
    annotationProcessor("com.google.dagger:dagger-compiler:2.4")

原理：APT，编译期间生成代码，最终仍然是 Object object = new Object(),其中利用了建造者模式
而且属性不能私有，因为instance.object在私有时无法访问到，当非同包时需要添加public；

@Component(modules = [Module::class])
@Module
@Inject
@Singleton 单利，全局单利可以在Application种实现DaggerComponent注入
注意区分Java和Kotlin两种方式的注解处理器的引入方式的差异
    implementation("com.google.dagger:dagger:2.51.1")
    kapt("com.google.dagger:dagger-compiler:2.51.1") // kapt
    annotationProcessor("com.google.dagger:dagger-compiler:2.51.1") // java

注意：接口Factory extends Provider

@Inject注解的类的构造函数
public enum HttpObject_Factory implements Factory<HttpObject>{
    INSTANCE;
    @Override
    public HttpObject get(){
        return new HttpObject();
    }
    public static Factory<HttpObject> create(){return INSTANCE}
}

@Module注解的类和@Provides注解的方法
public class HttpModule_ProviderHttpObjectFactory implements Factory<HttpObject>{
    private HttpObjectModule httpObjectModule;

    public HttpModule_ProvideHttpObjectFactory(HttpObjectModule objectModule){
        this.httpObjectModule = objectModule;
    }

    @Override
    public HttpObject get(){
        return httpObjectModule.providerHttpObject();
    }

    public static Factory<HttpObject> create(HttpModule module){
        return new HttpModule_ProviderHttpObjectFactory(module);
    }
}

@Component注解的类
public DaggerHttpComponent implements HttpComponent{
    Provider<HttpObject> providerHttpObjectProvider;
    MembersInjector<ktMainActivity> ktMainActivityMembersInjector;
    MembersInjector<MainActivity> mainActivityMembersInjector;

    private DaggerHttpComponent(Builder builder){
        assert builder != null;
        // 这里需要@Inject注解生成内容
        initialize(builder);
    }

    private void initialize(final Builder builder){
        this.providerHttpObjectProvider = HttpModule_ProviderHttpObjectFactory.create(builder.httpModule);
        this.ktMainActivityMembersInjector = KtMainActivity_MembersInjector.create(providerHttpObjectProvider);
        this.mainActivityMembersInjector = MainActivity_MembersInjector.create(providerHttpObjectProvider);
    }

    public static Builder builder(){
        return new Builder();
    }

    public static HttpComponent create() {
        return builder().build();
    }

    @Override
    public void injectKtMainActivity(KtMainActivity activity){
        ktMainActivityMembersInjector.injectMember(activity)
    }

    @Override
    public void injectMainActivity(MainActivity activity){
        mainActivityMembersInjector.injectMember(activity)
    }

    public static final class Builder{
        private HttpModule httpModule;
        private Builder(){
        }

        public HttpComponent build(){
            if(httpModule == null){
                this.httpModule = new DogModule();
            }
            return new DaggerHttpComponent(this);
        }

        public Builder httpModule(HttpModule httpModule){
            this.httpModule = httpModule;
            return this;
        }
    }
}


@Inject注解使用类的属性上
public class MainActivity_MembersInjector implements MemberInject<MainActivity>{}
public class KtMainActivity_MembersInjector implements MemberInjector<KtMainActivity>{

    private Provider<HttpObject> httpProvider;
    public KtMainActivity_MembersInjector(Provider<HttpObject> httpProvider){
        this.httpProvider = httpProvider;
    }

    public static KtMainActivity_MembersInjector create(Provider<HttpObject> httpProvider){
        return new KtMainActivity_MembersInjector(httpProvider)
    }

    @Override
    public void injectorMembers(KtMainActivity instance){
        instance.httpObject1 = httpProvider.get();
        instance.httpObject2 = httpProvider.get();
    }
}




Hilt Dagger2的二次封装