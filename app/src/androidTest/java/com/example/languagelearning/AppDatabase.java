package com.example.languagelearning;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.languagelearning.model.Achievement;
import com.example.languagelearning.model.Language;
import com.example.languagelearning.model.Lesson;

// AppDatabase.java
@Database(entities = {Language.class, Lesson.class, Achievement.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract LanguageDao languageDao();
    public abstract LessonDao lessonDao();
    public abstract AchievementDao achievementDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "your_database_name")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
