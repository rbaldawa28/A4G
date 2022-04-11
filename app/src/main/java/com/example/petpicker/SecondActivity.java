package com.example.petpicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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
        updateViews(sp);
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
                editor.putString("nameP",nameStr);
                editor.putInt("budgetP",budgetVal);
                editor.putInt("ageP",ageVal);
                editor.putInt("sqftP",sqftVal);
                editor.putInt("householdSizeP",householdSizeVal);
                editor.putInt("timeP",timeVal);
                editor.putBoolean("dogP", bDog);
                editor.putBoolean("catP", bCat);
                editor.putBoolean("birdP", bBird);
                editor.putBoolean("hamsterP", bHamster);
                editor.putBoolean("fishP", bFish);
                editor.commit();

            }
        });


    }

    public void openFirstActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void updateViews(SharedPreferences sp) {
        name.setText(sp.getString("nameP", ""));
    }
}
