/**
 * The page that displays the recommended pet options and can lead to more information (videos & locations for resources/adoption) about each pet.
 * The pets are displayed in the order of most recommended (top) to least recommended (bottom).
 * Recommendation made using algorithm (Pets class).
 * @author rbaldawa28, amchong, ibateman
 */

package com.example.petpicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class Options extends AppCompatActivity {

    /**
     * Different levels of recommendation for different pets.
     */
    TextView firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice;


    /**
     * Returns to the Home (homepage) when the back button on the device is pressed
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    /**
     * Creates options from SharedPreferences (user's saved information) and sets text based on ordering when the recommended pets page is opened/reopened
     */
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);

        Pets options = new Pets(sp);

        firstChoice.setText("1. " + options.getFirst());
        secondChoice.setText("2. " + options.getSecond());
        thirdChoice.setText("3. " + options.getThird());
        fourthChoice.setText("4. " + options.getFourth());
        fifthChoice.setText("5. " + options.getFifth());
    }

    /**
     * Displays the recommended pets options
     * Pets displayed in the order of ranking (highest recommendation to lowest recommendation)
     * All pets have options (buttons) for more information about each pet
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        /**
         * Button for opening more information activity about the 1st recommended pet option
         */
        MaterialButton option1 = findViewById(R.id.firstPet);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1();
            }
        });

        /**
         * Button for opening more information activity about the 2nd recommended pet option
         */
        MaterialButton option2 = findViewById(R.id.secondPet);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2();
            }
        });

        /**
         * Button for opening more information activity about the 3rd recommended pet option
         */
        MaterialButton option3 = findViewById(R.id.thirdPet);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3();
            }
        });

        /**
         * Button for opening more information activity about the 4th recommended pet option
         */
        MaterialButton option4 = findViewById(R.id.fourthPet);
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4();
            }
        });

        /**
         * Button for opening more information activity about the 5th recommended pet option
         */
        MaterialButton option5 = findViewById(R.id.fifthPet);
        option5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open5();
            }
        });

        firstChoice = findViewById(R.id.firstChoice);
        secondChoice = findViewById(R.id.secondChoice);
        thirdChoice = findViewById(R.id.thirdChoice);
        fourthChoice = findViewById(R.id.fourthChoice);
        fifthChoice = findViewById(R.id.fifthChoice);

        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);

        Pets options = new Pets(sp);

        /**
         * Create options from SharedPreferences and set text based on ordering
         */
        firstChoice.setText("1. " + options.getFirst());
        secondChoice.setText("2. " + options.getSecond());
        thirdChoice.setText("3. " + options.getThird());
        fourthChoice.setText("4. " + options.getFourth());
        fifthChoice.setText("5. " + options.getFifth());
    }

    /**
     * Opens activity for information about the 1st recommended pet
     */
    public void open1()
    {
        Intent intent = new Intent(this, Option1.class);
        startActivity(intent);
    }

    /**
     * Opens activity for information about the 2nd recommended pet
     */
    public void open2()
    {
        Intent intent = new Intent(this, Option2.class);
        startActivity(intent);
    }

    /**
     * Opens activity for information about the 3rd recommended pet
     */
    public void open3()
    {
        Intent intent = new Intent(this, Option3.class);
        startActivity(intent);
    }

    /**
     * Opens activity for information about the 4th recommended pet
     */
    public void open4()
    {
        Intent intent = new Intent(this, Option4.class);
        startActivity(intent);
    }

    /**
     * Opens activity for information about the 5th recommended pet
     */
    public void open5()
    {
        Intent intent = new Intent(this, Option5.class);
        startActivity(intent);
    }
}
