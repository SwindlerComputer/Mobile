package com.example.languagelearning;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.languagelearning.model.Lesson;

// LessonDao.java
@Dao
public interface LessonDao {
    @Insert
    void insert(Lesson lesson);


}
