package com.example.languagelearning.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Language class
@Entity
public class Language {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;


}
