package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LessonActivity extends AppCompatActivity {

    private String selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        // Gets selected language from intent
        if (getIntent() != null && getIntent().hasExtra("language")) {
            selectedLanguage = getIntent().getStringExtra("language");
        }

        // Display the selected language in a Toast
        if (selectedLanguage != null) {
            Toast.makeText(this, "Lesson for " + selectedLanguage, Toast.LENGTH_SHORT).show();
        }

        // Start Quiz button
        Button startQuizButton = findViewById(R.id.startQuizButton);
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the quiz activity
                startQuiz();
            }
        });


    }

    // Method for starting the quiz activity
    private void startQuiz() {
        Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
        intent.putExtra("language", selectedLanguage);
        startActivity(intent);
    }
}
