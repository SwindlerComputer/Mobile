package com.example.languagelearning;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.languagelearning.model.Achievement;

// AchievementDao.java
@Dao
public interface AchievementDao {
    @Insert
    void insert(Achievement achievement);


}