package com.douglas.kotlinone.jetpack.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface StudentDao {
    @Insert
    void insert(Student... students);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);
}
