package com.example.petpicker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

    EditText name, budget, age, sqft, householdSize, time;
    Button submit;
    SharedPreferences sp;
    String nameStr;
    double budgetVal, ageVal, sqftVal, householdSizeVal, timeVal;
    boolean wDog, wCat, wBird, wHamster, wFish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    protected void onClick(Bundle savedInstanceState)
    {

    }
}
