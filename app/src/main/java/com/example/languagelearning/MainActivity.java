package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button englishButton;
    private Button spanishButton;
    private Button frenchButton;
    private Button lessonButton;

    private String selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lessonButton = findViewById(R.id.lessonButton);
        englishButton = findViewById(R.id.englishButton);
        spanishButton = findViewById(R.id.spanishButton);
        frenchButton = findViewById(R.id.frenchButton);

        lessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedLanguage != null) {
                    // Redirect to NativeLanguageActivity after selecting a language
                    startNativeLanguageActivity();
                } else {
                    // Display a toast message if no language is selected when the user tries to start a lesson
                    Toast.makeText(MainActivity.this, "Please select a language", Toast.LENGTH_SHORT).show();
                }
            }
        });

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLanguageButtonClick("English", englishButton);
            }
        });

        spanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLanguageButtonClick("Spanish", spanishButton);
            }
        });

        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLanguageButtonClick("French", frenchButton);
            }
        });
    }

    private void handleLanguageButtonClick(String language, Button selectedButton) {
        // Display a toast message when a language button is clicked
        Toast.makeText(MainActivity.this, "You have selected " + language, Toast.LENGTH_SHORT).show();

        // Highlights the selected button
        resetButtonHighlights();
        selectedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        // Sets the selected language
        selectedLanguage = language;
    }

    private void resetButtonHighlights() {
        // Reset the background color of all buttons once one is chosen
        englishButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        spanishButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        frenchButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    // This is for the selected language, e.g. English
    private void startNativeLanguageActivity() {
        // Start NativeLanguageActivity after selecting a native language
        Intent intent = new Intent(MainActivity.this, NativeLanguageActivity.class);
        intent.putExtra("nativeLanguage", selectedLanguage);
        startActivity(intent);
    }

    // If the user selects "Start Lesson," they are able to go back with the button when pressed
    @Override
    public void onBackPressed() {
        // Handle the back button press (e.g., navigate back to MainActivity)
        super.onBackPressed();
    }
}
