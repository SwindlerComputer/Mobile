package com.example.languagelearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        // This display a language lesson
        TextView lessonTextView = findViewById(R.id.lessonTextView);
        lessonTextView.setText("Lesson: Basic Greetings\nHello, how are you?");

        // placeholders for interactive exercises
        Button quizButton = findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will start a quiz or interactive exercise
            }
        });
    }
}


