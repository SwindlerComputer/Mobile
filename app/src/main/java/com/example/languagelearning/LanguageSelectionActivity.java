package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class LanguageSelectionActivity extends AppCompatActivity {

    private Button startLessonButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        startLessonButton = findViewById(R.id.startLessonButton);

        startLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToLessonActivity();
            }
        });
    }

    private void goToLessonActivity() {
        Intent intent = new Intent(LanguageSelectionActivity.this, LessonActivity.class);
        // Pass the native language to the LessonActivity
        intent.putExtra("nativeLanguage", getIntent().getStringExtra("nativeLanguage"));
        startActivity(intent);

    }
}
