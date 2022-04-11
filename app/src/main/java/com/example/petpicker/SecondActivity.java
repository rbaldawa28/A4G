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


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstActivity();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("nameP",name.getText().toString());
                editor.putInt("budgetP",Integer.parseInt(budget.getText().toString()));
                editor.putInt("ageP",Integer.parseInt(age.getText().toString()));
                editor.putInt("sqftP",Integer.parseInt(sqft.getText().toString()));
                editor.putInt("householdSizeP",Integer.parseInt(householdSize.getText().toString()));
                editor.putInt("timeP",Integer.parseInt(time.getText().toString()));
                editor.putBoolean("dogP", dog.isChecked());
                editor.putBoolean("catP", cat.isChecked());
                editor.putBoolean("birdP", bird.isChecked());
                editor.putBoolean("hamsterP", hamster.isChecked());
                editor.putBoolean("fishP", fish.isChecked());
                editor.apply();

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        // Setting the fetched data
        // in the EditTexts
        name.setText(sp.getString("nameP",""));
    }

    public void openFirstActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
