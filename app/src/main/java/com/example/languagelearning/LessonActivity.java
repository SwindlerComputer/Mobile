package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LessonActivity extends AppCompatActivity {

    private String selectedLanguage;
    private TextView lessonContentTextView;
    private Button startQuizButton;
    private Button practiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        // Retrieve selected language from intent
        if (getIntent() != null && getIntent().hasExtra("language")) {
            selectedLanguage = getIntent().getStringExtra("language");
        }

        // Example: Display the selected language in a Toast
        if (selectedLanguage != null) {
            Toast.makeText(this, "Lesson for " + selectedLanguage, Toast.LENGTH_SHORT).show();
        }

        // Example: Add interactive elements to the lesson content
        lessonContentTextView = findViewById(R.id.lessonContentTextView);
        if (lessonContentTextView != null) {
            lessonContentTextView.setText("Interactive lesson content for " + selectedLanguage);
            lessonContentTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Add logic for interactive elements
                    Toast.makeText(LessonActivity.this, "Interactive element clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }

        // Example: Add lesson progress tracker (progress bar)
        ProgressBar progressBar = findViewById(R.id.progressBar);
        if (progressBar != null) {
            // Set progress based on user's completion
            progressBar.setProgress(50); // Example: 50% completion
        }

        // Start Quiz button
        startQuizButton = findViewById(R.id.startQuizButton);
        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the quiz activity
                startQuiz();
            }
        });

        // Practice button
        practiceButton = findViewById(R.id.practiceButton);
        practiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the practice activity
                startPractice();
            }
        });

        // Add a button to navigate back to MainActivity
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the LessonActivity and go back to MainActivity
            }
        });
    }

    // Method to start the quiz activity
    private void startQuiz() {
        Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
        intent.putExtra("language", selectedLanguage);
        startActivity(intent);
    }

    // Method to start the practice activity
    private void startPractice() {
        Intent intent = new Intent(LessonActivity.this, PracticeActivity.class);
        intent.putExtra("language", selectedLanguage);
        startActivity(intent);
    }
}
