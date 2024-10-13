package com.douglas.kotlinone.jetpack.databinding;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

/**
 * Created by liudagang on 2024/10/13.
 * <p>
 * Package Name KotlinOne
 */
// 必须是public
public class User extends BaseObservable{
   private String name;
   private String pwd;

   public User(String pwd, String name) {
      this.pwd = pwd;
      this.name = name;
   }

   @Bindable
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
      notifyPropertyChanged(BR.name);
   }

   @Bindable
   public String getPwd() {
      return pwd;
   }

   public void setPwd(String pwd) {
      this.pwd = pwd;
      notifyPropertyChanged(BR.pwd);
   }
}
