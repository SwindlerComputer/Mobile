package com.example.languagelearning;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.languagelearning.model.Language;

import java.util.List;

// LanguageDao.java
@Dao
public interface LanguageDao {
    @Insert
    void insert(Language language);

    @Query("SELECT * FROM language")
    List<Language> getAllLanguages();
}