package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class NativeLanguageActivity extends AppCompatActivity {

    private Spinner learnLanguageSpinner;
    private Button startLessonButton;
    private String selectedLearnLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_language);

        learnLanguageSpinner = findViewById(R.id.learnLanguageSpinner);
        startLessonButton = findViewById(R.id.startLessonButton);

        // Retrieve the native language passed from MainActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nativeLanguage")) {
            String nativeLanguage = intent.getStringExtra("nativeLanguage");
            // Do something with the nativeLanguage if needed
        }

        // Populate the spinner with a list of languages to learn
        List<String> languagesToLearn = getAvailableLanguagesToLearn();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languagesToLearn);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        learnLanguageSpinner.setAdapter(adapter);

        startLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLearnLanguage = getSelectedLanguageFromSpinner();
                if (selectedLearnLanguage != null) {
                    // Handle the selection, for example, start a lesson or show more options
                    // For now, let's go to the LessonActivity
                    startLesson();
                } else {
                    // Handle the case where no language is selected
                    Toast.makeText(NativeLanguageActivity.this, "Please select a language to learn", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<String> getAvailableLanguagesToLearn() {
        // Replace this with your logic to get a list of available languages to learn
        List<String> languagesToLearn = new ArrayList<>();
        languagesToLearn.add("English");
        languagesToLearn.add("Spanish");
        languagesToLearn.add("French");
        // Add more languages as needed
        return languagesToLearn;
    }

    private String getSelectedLanguageFromSpinner() {
        return learnLanguageSpinner.getSelectedItem().toString();
    }

    private void startLesson() {
        // For now, let's go to the LessonActivity
        Intent intent = new Intent(NativeLanguageActivity.this, LessonActivity.class);
        intent.putExtra("learnLanguage", selectedLearnLanguage);
        startActivity(intent);
        finish(); // Optional: Close the current activity
    }
}
