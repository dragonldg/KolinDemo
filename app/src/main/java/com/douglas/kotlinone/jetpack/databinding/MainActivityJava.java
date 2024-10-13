package com.douglas.kotlinone.jetpack.databinding;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.douglas.kotlinone.R;
import com.douglas.kotlinone.databinding.ActivityMainDatabindingBinding;

public class MainActivityJava extends AppCompatActivity {
//    MainActivityB
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //(R.layout.activity_main_databinding);
        // 这里的名称是根据xml文件来命名的,和类名无关
        ActivityMainDatabindingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main_databinding);
        user = new User("666666","douglas");
        binding.setUser(user); // 建立绑定关系 setXXX,XXX为配置文件的变量名
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    // 数据到View
                    user.setName(user.getName()+"O");
                    user.setPwd(user.getPwd()+"11");
                }catch (Exception e){
                    System.out.println(e.getLocalizedMessage());
                }

            }
        }).start();
    }
}