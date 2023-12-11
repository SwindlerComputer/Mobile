package com.example.languagelearning;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProgressActivity extends AppCompatActivity {

    private TextView progressTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        // Example: Display progress information
        progressTextView = findViewById(R.id.progressTextView);
        progressBar = findViewById(R.id.progressBar);

        updateProgress("You've completed 3 lessons!", 3); // Initial progress example

        // Add more functionality as needed
    }

    // Example method to update progress text and progress bar
    private void updateProgress(String progress, int completedLessons) {
        if (progressTextView != null) {
            progressTextView.setText(progress);
        }

        if (progressBar != null) {
            // Set progress based on the number of completed lessons
            int totalLessons = 10; // Example: Total lessons
            int progressValue = (int) ((float) completedLessons / totalLessons * 100);
            progressBar.setProgress(progressValue);
        }
    }
}
