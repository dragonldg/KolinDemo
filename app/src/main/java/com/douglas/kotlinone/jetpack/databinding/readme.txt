viewbinding原理：gradle直接将xml转为Java文件，命名为xml文件名+binding；

MVC
V+C：Activity：Controller，同时控制view，控制，模型的事情，违背单一指责
V：XML：view，纯页面
M：Model：数据库，网络


MVP
V：Activity，控制View层
P：控制逻辑
M：数据
定义太多的接口回调

MVVM
V：activity
VM：不同于Jetpack的ViewModel，用来桥接V和M，借助的是Databinding，不属于MVVM内部的东西
M：数据

databinding 绑定的是页面层和viewmodel层,利用的是APT技术;
开启开关：dataBinding { enable = true }
添加依赖:implementation(libs.androidx.databinding.runtime)
数据类必须是public,否则生成的类无法访问;

原理:APT技术,编译过程会扫描注解和布局文件,将布局文件拆分为两个,一个Binding使用,一个Android使用,并为外层布局添加tag;
@和@=的区别?
后者表示view-》Model(data);Model->view
前者表示只能Model-》view

根据tag查找布局中的控件;





