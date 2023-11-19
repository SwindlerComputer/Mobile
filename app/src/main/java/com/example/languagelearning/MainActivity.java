package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lessonButton = findViewById(R.id.lessonButton);
        lessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedLanguage != null) {
                    launchLessonActivity(selectedLanguage);
                } else {

                }
            }
        });

       // languages chosen so far
        Button englishButton = findViewById(R.id.englishButton);
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLanguage = "English";
            }
        });

        Button spanishButton = findViewById(R.id.spanishButton);
        spanishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLanguage = "Spanish";
            }
        });

        Button frenchButton = findViewById(R.id.frenchButton);
        frenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLanguage = "French";
            }
        });
    }
    //This is for the selected language e.g english
    private void launchLessonActivity(String language) {
        //This navigates from main to lesson activity
        Intent intent = new Intent(MainActivity.this, LessonActivity.class);
        intent.putExtra("language", language);
        startActivity(intent);
    }
}
