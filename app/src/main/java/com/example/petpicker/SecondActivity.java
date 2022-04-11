package com.example.petpicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity{

    EditText name, budget, age, sqft, householdSize, time;
    CheckBox dog, cat, bird, hamster, fish;
    MaterialButton submit, back;
    SharedPreferences sp;
    String nameStr;
    int budgetVal, ageVal, sqftVal, householdSizeVal, timeVal;
    boolean bDog, bCat, bBird, bHamster, bFish;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.name);
        budget = findViewById(R.id.budget);
        age = findViewById(R.id.age);
        sqft = findViewById(R.id.size);
        householdSize = findViewById(R.id.householdSize);
        time = findViewById(R.id.timeAtHome);
        submit = findViewById(R.id.submit);
        back = findViewById(R.id.back);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        bird = findViewById(R.id.bird);
        hamster = findViewById(R.id.hamster);
        fish = findViewById(R.id.fish);

        sp = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstActivity();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = name.getText().toString();
                budgetVal = Integer.parseInt(budget.getText().toString());
                ageVal = Integer.parseInt(age.getText().toString());
                sqftVal = Integer.parseInt(sqft.getText().toString());
                householdSizeVal = Integer.parseInt(householdSize.getText().toString());
                timeVal = Integer.parseInt(time.getText().toString());
                bDog = dog.isChecked();
                bCat = cat.isChecked();
                bBird = bird.isChecked();
                bHamster = hamster.isChecked();
                bFish = fish.isChecked();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name",nameStr);
                editor.putInt("budget",budgetVal);
                editor.putInt("age",ageVal);
                editor.putInt("sqft",sqftVal);
                editor.putInt("householdSize",householdSizeVal);
                editor.putInt("time",timeVal);
                editor.putBoolean("dog", bDog);
                editor.putBoolean("cat", bCat);
                editor.putBoolean("bird", bBird);
                editor.putBoolean("hamster", bHamster);
                editor.putBoolean("fish", bFish);
                editor.commit();
            }
        });
    }

    public void openFirstActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
