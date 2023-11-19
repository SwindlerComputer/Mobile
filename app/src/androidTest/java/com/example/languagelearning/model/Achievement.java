package com.example.languagelearning.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

// Achievement class
@Entity
public class Achievement {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;
    public String description;

    @ColumnInfo(name = "language_id")
    public int languageId;


}
