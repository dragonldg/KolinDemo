package com.douglas.kotlinone.jetpack.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student.class,version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase database;
    public static MyDatabase getInstance(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class,"Douglas")
                    .allowMainThreadQueries().build();
        }
        return database;
    }


    public abstract StudentDao studentDao();
}
