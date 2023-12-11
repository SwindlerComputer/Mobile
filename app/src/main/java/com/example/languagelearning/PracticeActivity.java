package com.example.languagelearning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class PracticeActivity extends AppCompatActivity {

    private EditText translationEditText;
    private Button submitButton;
    private String selectedLanguage;

    // Map to store language-specific challenges
    private Map<String, String> challenges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        translationEditText = findViewById(R.id.translationEditText);
        submitButton = findViewById(R.id.submitButton);

        // Retrieve selected language from the intent
        if (getIntent() != null && getIntent().hasExtra("selectedLanguage")) {
            selectedLanguage = getIntent().getStringExtra("selectedLanguage");
        }

        // Initialize challenges
        initializeChallenges();

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

        // Generate and display the first practice task
        generatePracticeTask();
    }

    // Initialize challenges for each language
    private void initializeChallenges() {
        challenges = new HashMap<>();
        challenges.put("English", "Translate the following: Hello");
        challenges.put("Spanish", "Translate the following: Hola");
        challenges.put("French", "Translate the following: Bonjour");
        // Add more challenges as needed
    }

    // Example method to generate and display a practice task
    private void generatePracticeTask() {
        // Get a challenge for the selected language
        String challenge = challenges.get(selectedLanguage);

        // Display the challenge
        // For simplicity, you might display it in a TextView
        // Example: TextView practiceChallengeTextView = findViewById(R.id.practiceChallengeTextView);
        // practiceChallengeTextView.setText(challenge);
    }

    // Example method to check the user's translation
    private void checkUserTranslation(String userTranslation) {
        // Get the correct translation for the current challenge
        String correctTranslation = challenges.get(selectedLanguage);

        // Check if the user's translation is correct
        if (userTranslation.equalsIgnoreCase(correctTranslation)) {
            // Correct translation
            // Provide feedback or take appropriate action
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            // Incorrect translation
            // Provide feedback or take appropriate action
            Toast.makeText(this, "Incorrect, try again!", Toast.LENGTH_SHORT).show();
        }

        // Generate and display a new practice task after checking the translation
        generatePracticeTask();
    }
}
