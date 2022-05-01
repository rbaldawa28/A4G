package com.example.petpicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class Options extends AppCompatActivity {

    EditText firstChoice, secondChoice, thirdChoice, fourthChoice, fifthChoice;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        MaterialButton option1 = findViewById(R.id.firstPet);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1();
            }
        });

        MaterialButton option2 = findViewById(R.id.secondPet);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2();
            }
        });

        MaterialButton option3 = findViewById(R.id.thirdPet);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3();
            }
        });

        MaterialButton option4 = findViewById(R.id.fourthPet);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4();
            }
        });

        MaterialButton option5 = findViewById(R.id.fifthPet);
        option1.setOnClickListener(new View.OnClickListener() {
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

        firstChoice.setText(options.getFirst());
        secondChoice.setText(options.getSecond());
        thirdChoice.setText(options.getThird());
        fourthChoice.setText(options.getFourth());
        fifthChoice.setText(options.getFifth());
    }
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
