package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private RadioButton option4RadioButton;
    private Button submitButton;

    private String[] questions;
    private String[] correctAnswers;
    private String[] incorrectOptions;
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // UI components
        questionTextView = findViewById(R.id.questionTextView);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        submitButton = findViewById(R.id.submitButton);

        // Get the selected language from the intent
        String selectedLanguage = getIntent().getStringExtra("language");

        // Load questions based on the selected language
        loadQuestions(selectedLanguage);

        // Displays the question
        showQuestion();

        // Set onClickListener for the Submit Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void loadQuestions(String language) {
        // Load questions based on the selected language
        String[] questions;
        String[] correctAnswers;
        String[] incorrectOptions;

        if ("es".equals(language)) {  // Spanish
            questions = getResources().getStringArray(R.array.quiz_questions_es);
            correctAnswers = getResources().getStringArray(R.array.quiz_correct_answers_es);
            incorrectOptions = getResources().getStringArray(R.array.quiz_incorrect_options_es);
        } else if ("fr".equals(language)) {  // French
            questions = getResources().getStringArray(R.array.quiz_questions_fr);
            correctAnswers = getResources().getStringArray(R.array.quiz_correct_answers_fr);
            incorrectOptions = getResources().getStringArray(R.array.quiz_incorrect_options_fr);
        } else {
            // Default to English
            questions = getResources().getStringArray(R.array.quiz_questions);
            correctAnswers = getResources().getStringArray(R.array.quiz_correct_answers);
            incorrectOptions = getResources().getStringArray(R.array.quiz_incorrect_options);
        }

        // Set the loaded questions
        this.questions = questions;
        this.correctAnswers = correctAnswers;
        this.incorrectOptions = incorrectOptions;
    }

    private void showQuestion() {
        // Displays the current question and options

        // Sets the question text
        questionTextView.setText(questions[currentQuestionIndex]);

        // Ensures that the correct answer is included in the options, had an issue where the answer wouldnt display this fixed it
        ArrayList<String> allOptions = new ArrayList<>();
        allOptions.add(correctAnswers[currentQuestionIndex]);

        // Adds the incorrect options until we have 4 options
        while (allOptions.size() < 4) {
            String randomIncorrectOption = incorrectOptions[(int) (Math.random() * incorrectOptions.length)];
            if (!allOptions.contains(randomIncorrectOption)) {
                allOptions.add(randomIncorrectOption);
            }
        }

        // Shuffle the options
        Collections.shuffle(allOptions);

        // Set the options
        option1RadioButton.setText(allOptions.get(0));
        option2RadioButton.setText(allOptions.get(1));
        option3RadioButton.setText(allOptions.get(2));
        option4RadioButton.setText(allOptions.get(3));
    }

    private void checkAnswer() {
        int selectedId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            String correctAnswer = correctAnswers[currentQuestionIndex];

            if (selectedAnswer.equals(correctAnswer)) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                // Increments correct answers count
                correctAnswersCount++;
            } else {
                Toast.makeText(this, "Incorrect, the correct answer is: " + correctAnswer, Toast.LENGTH_SHORT).show();
            }

            // goes to the next question
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.length) {
                showQuestion();
                // Clear the selected radio button
                optionsRadioGroup.clearCheck();
            } else {
                // Quiz is complete, handle accordingly, it will return to the main menu
                finish();
            }
        } else {
            // No option selected
            Toast.makeText(this, "Please select an option.", Toast.LENGTH_SHORT).show();
        }
    }
}
