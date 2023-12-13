package com.example.languagelearning;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class PracticeActivity extends AppCompatActivity {

    private EditText translationEditText;
    private Button submitButton;
    private TextView practiceChallengeTextView;
    private String selectedLanguage;

    // Map to store language-specific challenges
    private Map<String, Challenge> challenges;

    // Challenge class to hold translation and cultural insight"Didn get to implement it properly"
    private static class Challenge {
        String translation;
        String culturalInsight;

        Challenge(String translation, String culturalInsight) {
            this.translation = translation;
            this.culturalInsight = culturalInsight;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        translationEditText = findViewById(R.id.translationEditText);
        submitButton = findViewById(R.id.submitButton);
        practiceChallengeTextView = findViewById(R.id.practiceChallengeTextView);

        // Gets selected language from the intent
        if (getIntent() != null && getIntent().hasExtra("selectedLanguage")) {
            selectedLanguage = getIntent().getStringExtra("selectedLanguage");
        }

        // Initialize challenges
        if (challenges == null) {
            initializeChallenges();
        }

        // Set an onClickListener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's translation
                String userTranslation = translationEditText.getText().toString();

                // Check the user's translation
                checkUserTranslation(userTranslation);
            }
        });

        // Generate and display the practice task
        generatePracticeTask();
    }

    // Initialize challenges for each language
    private void initializeChallenges() {
        challenges = new HashMap<>();
        challenges.put("English", new Challenge("Translate the following: Hello", "In English, 'Hello' is a common greeting."));
        challenges.put("Spanish", new Challenge("Translate the following: Hola", "In Spanish-speaking cultures, 'Hola' is used as a friendly greeting."));
        challenges.put("French", new Challenge("Translate the following: Bonjour", "In French culture, 'Bonjour' is a polite way to say 'Good morning'."));

    }

    //  generate and display a practice task
    private void generatePracticeTask() {
        if (selectedLanguage != null && challenges != null) {
            Challenge challenge = challenges.get(selectedLanguage);

            if (challenge != null) {
                // Display the challenge and cultural insight
                practiceChallengeTextView.setText(challenge.translation + "\n\n" + challenge.culturalInsight);
            } else {
                Log.e("PracticeActivity", "Challenge for selected language is null");
                Toast.makeText(this, "Error: Challenge for selected language is null", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("PracticeActivity", "Selected language or challenges are not initialized properly");
            Toast.makeText(this, "Error: Selected language or challenges are not initialized properly", Toast.LENGTH_SHORT).show();
        }
    }

    // method to check the user's translation
    private void checkUserTranslation(String userTranslation) {
        if (selectedLanguage != null && challenges != null) {
            Challenge challenge = challenges.get(selectedLanguage);

            if (challenge != null) {
                // Get the correct translation for the current challenge
                String correctTranslation = challenge.translation;

                // Check if the user's translation is correct
                if (userTranslation.equalsIgnoreCase(correctTranslation)) {
                    // Correct translation
                    // Provide feedback or take appropriate action
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    // Incorrect translation
                    // Displays feedback
                    Toast.makeText(this, "Incorrect, try again!", Toast.LENGTH_SHORT).show();
                }

                // Generates and displays a new practice task after checking the translation
                generatePracticeTask();
            } else {
                Log.e("PracticeActivity", "Challenge for selected language is null");
                Toast.makeText(this, "Error: Challenge for selected language is null", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("PracticeActivity", "Selected language or challenges are not initialized properly");
            Toast.makeText(this, "Error checking user translation. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
