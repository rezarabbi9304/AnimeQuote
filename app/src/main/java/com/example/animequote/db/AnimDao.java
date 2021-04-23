package com.example.animequote.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.animequote.AnimModel;

import java.util.List;

@Dao
public interface AnimDao {

    @Query("SELECT * FROM AnimModel")
    List<AnimModel> getAllAnim();


    @Insert
    Long insetAnim(AnimModel animModels);
}
