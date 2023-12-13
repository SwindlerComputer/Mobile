package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class NativeLanguageActivity extends AppCompatActivity {

    private Spinner learnLanguageSpinner;
    private Button startLessonButton;
    private Button startPracticeButton;
    private String selectedLearnLanguage;

    private List<String> wordOfTheDayList = Arrays.asList(
            "hello", "hola", "bonjour", "world", "mundo", "monde", "java", "espanol", "francais",
            "code", "codigo", "code", "programming", "programacion", "programmation", "computer",
            "computadora", "ordinateur", "learning", "aprendizaje", "apprentissage", "technology",
            "tecnologia", "technologie", "software", "software", "logiciel", "developer",
            "desarrollador", "developpeur", "internet", "internet", "internet", "mobile", "movil",
            "mobile", "algorithm", "algoritmo", "algorithme", "database", "base de datos",
            "base de donnees", "cloud", "nube", "nuage"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_language);

        learnLanguageSpinner = findViewById(R.id.learnLanguageSpinner);
        startLessonButton = findViewById(R.id.startLessonButton);
        startPracticeButton = findViewById(R.id.startPracticeButton);

        List<String> availableLanguages = getAvailableLanguagesToLearn();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                availableLanguages
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        learnLanguageSpinner.setAdapter(spinnerAdapter);

        displayWordOfTheDay();
        displayTimeAndDate();

        startLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLearnLanguage = getSelectedLanguageFromSpinner();
                if (selectedLearnLanguage != null) {
                    startLesson();
                } else {
                    Toast.makeText(NativeLanguageActivity.this, "Please select a language to learn", Toast.LENGTH_SHORT).show();
                }
            }
        });

        startPracticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPractice();
            }
        });

        Button randomizeWordButton = findViewById(R.id.randomizeWordButton);
        randomizeWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayWordOfTheDay();
            }
        });

        Button funFactsButton = findViewById(R.id.funFactsButton);
        funFactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFunFactsActivity(selectedLearnLanguage);
            }
        });
    }

    private List<String> getAvailableLanguagesToLearn() {
        return Arrays.asList("English", "Spanish", "French");
    }

    private String getSelectedLanguageFromSpinner() {
        return learnLanguageSpinner.getSelectedItem().toString();
    }

    private void startLesson() {
        Intent intent = new Intent(NativeLanguageActivity.this, LessonActivity.class);
        intent.putExtra("learnLanguage", selectedLearnLanguage);
        startActivity(intent);
        finish();
    }

    private void startPractice() {
        Intent intent = new Intent(NativeLanguageActivity.this, PracticeActivity.class);
        intent.putExtra("selectedLanguage", selectedLearnLanguage);
        startActivity(intent);
        finish();
    }

    private void startFunFactsActivity(String selectedLearnLanguage) {
        Intent intent = new Intent(NativeLanguageActivity.this, FunFactsActivity.class);
        intent.putExtra("selectedLanguage", selectedLearnLanguage);
        startActivity(intent);
    }

    private void displayTimeAndDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        String currentDate = dateFormat.format(calendar.getTime());
        String currentTime = timeFormat.format(calendar.getTime());

        TextView dateTimeTextView = findViewById(R.id.dateTimeTextView);
        dateTimeTextView.setText("Date: " + currentDate + "\nTime: " + currentTime);
    }

    private void displayWordOfTheDay() {
        Random random = new Random();
        String wordOfTheDay = wordOfTheDayList.get(random.nextInt(wordOfTheDayList.size()));

        TextView wordOfTheDayTextView = findViewById(R.id.wordOfTheDayTextView);
        wordOfTheDayTextView.setText("Word of the Day: " + wordOfTheDay);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NativeLanguageActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
