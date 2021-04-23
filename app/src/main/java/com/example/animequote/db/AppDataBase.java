package com.example.animequote.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.animequote.AnimModel;

@Database(entities = AnimModel.class,version = 1)
public  abstract class AppDataBase extends RoomDatabase {

    public abstract AnimDao animDao();

    private static AppDataBase INSTANCE;

    public static AppDataBase getINSTANCE(Context context) {

        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"DB_anim")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}
