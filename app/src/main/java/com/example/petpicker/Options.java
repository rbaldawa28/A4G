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

    TextView firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);

        Pets options = new Pets(sp);
        //Create options from SharedPreferences and set text based on ordering

        firstChoice.setText("1. " + options.getFirst());
        secondChoice.setText("2. " + options.getSecond());
        thirdChoice.setText("3. " + options.getThird());
        fourthChoice.setText("4. " + options.getFourth());
        fifthChoice.setText("5. " + options.getFifth());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        //Creates buttons for options for the next page
        MaterialButton option1 = findViewById(R.id.firstPet);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1();
            }
        });

        MaterialButton option2 = findViewById(R.id.secondPet);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2();
            }
        });

        MaterialButton option3 = findViewById(R.id.thirdPet);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3();
            }
        });

        MaterialButton option4 = findViewById(R.id.fourthPet);
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4();
            }
        });

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

        //Create options from SharedPreferences and set text based on ordering
        firstChoice.setText("1. " + options.getFirst());
        secondChoice.setText("2. " + options.getSecond());
        thirdChoice.setText("3. " + options.getThird());
        fourthChoice.setText("4. " + options.getFourth());
        fifthChoice.setText("5. " + options.getFifth());
    }

    //Methods for opening activities
    public void open1()
    {
        Intent intent = new Intent(this, Option1.class);
        startActivity(intent);
    }

    public void open2()
    {
        Intent intent = new Intent(this, Option2.class);
        startActivity(intent);
    }

    public void open3()
    {
        Intent intent = new Intent(this, Option3.class);
        startActivity(intent);
    }

    public void open4()
    {
        Intent intent = new Intent(this, Option4.class);
        startActivity(intent);
    }

    public void open5()
    {
        Intent intent = new Intent(this, Option5.class);
        startActivity(intent);
    }
}
