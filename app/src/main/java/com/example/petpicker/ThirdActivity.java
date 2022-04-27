package com.example.petpicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.*;


public class ThirdActivity extends AppCompatActivity {

    EditText firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        firstChoice = findViewById(R.id.firstChoice);
        secondChoice = findViewById(R.id.secondChoice);
        thirdChoice = findViewById(R.id.thirdChoice);
        fourthChoice = findViewById(R.id.fourthChoice);
        fifthChoice = findViewById(R.id.fifthChoice);

        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);

        Pets options = new Pets(sp);

        firstChoice.setText(options.getFirst());
        secondChoice.setText(options.getSecond());
        thirdChoice.setText(options.getThird());
        fourthChoice.setText(options.getFourth());
        fifthChoice.setText(options.getFifth());
    }
}
