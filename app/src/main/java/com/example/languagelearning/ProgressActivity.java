package com.example.languagelearning;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        //data for user progress and achievements
        TextView progressTextView = findViewById(R.id.progressTextView);
        progressTextView.setText("Progress: 50%\nAchievements: Beginner Level");

    }
}


