package com.example.languagelearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FunFactsActivity extends AppCompatActivity {

    // Declare funFactsList
    private List<String> funFactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Gets the selected language from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("languageToLearn")) {
            String selectedLanguage = intent.getStringExtra("languageToLearn");
            // fun facts based on the selected language
            loadFunFacts(selectedLanguage);
        } else {
            // Handle the case where no language is selected
            // For example, display a message or go back to the previous activity
            finish();
        }
    }

    private void loadFunFacts(String selectedLanguage) {
        // Clear the list to avoid duplicates when reloading
        funFactsList.clear();

        // fun facts on the selected language user chose
        switch (selectedLanguage) {
            case "English":
                funFactsList.addAll(Arrays.asList(getResources().getStringArray(R.array.fun_facts_english)));
                break;
            case "Spanish":
                funFactsList.addAll(Arrays.asList(getResources().getStringArray(R.array.fun_facts_spanish)));
                break;
            case "French":
                funFactsList.addAll(Arrays.asList(getResources().getStringArray(R.array.fun_facts_french)));
                break;
        }

        // Displays fun facts in a ListView
        ListView funFactsListView = findViewById(R.id.funFactsListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, funFactsList);
        funFactsListView.setAdapter(adapter);
    }

    public void onRandomizeFactClick(View view) {
        // Your code to randomize and display a fun fact goes here
        displayRandomFunFact();
    }

    private void displayRandomFunFact() {
        // Code to get a random fun fact and display it


        // : updates a TextView with the random fun fact
        TextView funFactTextView = findViewById(R.id.funFactTextView);
        String randomFunFact = getRandomFunFact(); // Implement this method to get a random fun fact
        funFactTextView.setText(randomFunFact);
    }

    private String getRandomFunFact() {
        // Gets a random fun fact based on the selected language
        // It will pick one fact randomly

        Random random = new Random();
        int randomIndex = random.nextInt(funFactsList.size());
        return funFactsList.get(randomIndex);
    }
}
