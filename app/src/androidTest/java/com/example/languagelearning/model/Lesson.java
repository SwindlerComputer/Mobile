package com.example.languagelearning.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Lesson class
@Entity
public class Lesson {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String content;

    @ColumnInfo(name = "language_id")
    public int languageId;


}
