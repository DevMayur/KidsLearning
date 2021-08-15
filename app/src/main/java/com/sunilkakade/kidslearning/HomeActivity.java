package com.sunilkakade.kidslearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sunilkakade.kidslearning.adapters.LearningAdapter;

public class HomeActivity extends AppCompatActivity {

    CardView cardAlphabetsMarathi,cardAlphabetsEnglish,cardNumbersMarathi;
    Button buttonAlphabetsMarathi,buttonAlphabetsEnglish,buttonNumbersMarathi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardAlphabetsMarathi = findViewById(R.id.card_alphabets_marathi);
        buttonAlphabetsMarathi = findViewById(R.id.button_alphabets_marathi);
        cardNumbersMarathi = findViewById(R.id.card_numbers_marathi);
        buttonNumbersMarathi = findViewById(R.id.button_numbers_marathi);
        cardAlphabetsEnglish = findViewById(R.id.card_alphabets_english);
        buttonAlphabetsEnglish = findViewById(R.id.button_alphabets_english);


        final Intent intent = new Intent(HomeActivity.this, LearnActivity.class);

        cardAlphabetsMarathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("group", 0);
                startActivity(intent);
            }
        });

        buttonAlphabetsMarathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("group", 0);
                startActivity(intent);
            }
        });

        cardNumbersMarathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("group", 1);
                startActivity(intent);
            }
        });

        buttonNumbersMarathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("group", 1);
                startActivity(intent);
            }
        });

        cardAlphabetsEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("group", 2);
                startActivity(intent);
            }
        });

        buttonAlphabetsEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("group", 2);
                startActivity(intent);
            }
        });

    }
}