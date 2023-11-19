package com.example.languagelearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        // Get the selected language from the intent
        String selectedLanguage = getIntent().getStringExtra("language");

        // Display a language lesson based on the selected language
        TextView lessonTextView = findViewById(R.id.lessonTextView);
        if (selectedLanguage != null) {
            String lessonContent = getLessonContent(selectedLanguage);
            lessonTextView.setText(lessonContent);
        } else {
            // Handle the case where no language is selected (this should not happen in your flow)
            Toast.makeText(this, "No language selected", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity if no language is selected
        }

        // Placeholders for interactive exercises
        Button quizButton = findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will start a quiz or interactive exercise
                Toast.makeText(LessonActivity.this, "Start Quiz", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getLessonContent(String language) {
        // If user chooses a language it will be dynamic and if they choose english it would be english
        //if they choose french it would be in french
        // Testing so far ( thinking of ways to do gestures
        switch (language) {
            case "English":
                return "Lesson: Basic Greetings in English\nHello, Good morning";
            case "Spanish":
                return "Lección: Saludos básicos en español\nHola, Buenos días";
            case "French":
                return "Leçon: Salutations de base en français\nBonjour, Bonne journée";
            default:
                return "Lesson content not available";
        }
    }
}
