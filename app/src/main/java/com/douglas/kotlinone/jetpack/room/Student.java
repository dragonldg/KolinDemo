package com.douglas.kotlinone.jetpack.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    int uid;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "pwd")
    String pwd;

    @ColumnInfo(name = "address")
    String address;

    public Student(String name, String pwd, String address) {
        this.name = name;
        this.pwd = pwd;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
