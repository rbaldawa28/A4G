package com.example.petpicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Profile extends AppCompatActivity{

    EditText name, budget, age, sqft, householdSize, time;
    CheckBox dog, cat, bird, hamster, fish;
    MaterialButton submit, back;
    SharedPreferences sp;
    String nameStr;
    int budgetVal, ageVal, sqftVal, householdSizeVal, timeVal;
    boolean bDog, bCat, bBird, bHamster, bFish;

    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.name);
        budget = findViewById(R.id.budget);
        age = findViewById(R.id.age);
        sqft = findViewById(R.id.sqft);
        householdSize = findViewById(R.id.householdSize);
        time = findViewById(R.id.timeAtHome);
        submit = findViewById(R.id.submit);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        bird = findViewById(R.id.bird);
        hamster = findViewById(R.id.hamster);
        fish = findViewById(R.id.fish);



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
                editor.putBoolean("DogP", dog.isChecked());
                editor.putBoolean("CatP", cat.isChecked());
                editor.putBoolean("BirdP", bird.isChecked());
                editor.putBoolean("HamsterP", hamster.isChecked());
                editor.putBoolean("FishP", fish.isChecked());
                editor.commit();
                Toast toast = Toast.makeText(getApplicationContext(), "Profile Saved", Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        name.setText(sp.getString("nameP",""));
        age.setText(String.valueOf(sp.getInt("ageP",0)));
        budget.setText(String.valueOf(sp.getInt("budgetP",0)));
        sqft.setText(String.valueOf(sp.getInt("sqftP",0)));
        householdSize.setText(String.valueOf(sp.getInt("householdSizeP",0)));
        time.setText(String.valueOf(sp.getInt("timeP",0)));
        dog.setChecked(sp.getBoolean("DogP",false));
        cat.setChecked(sp.getBoolean("CatP",false));
        bird.setChecked(sp.getBoolean("BirdP",false));
        hamster.setChecked(sp.getBoolean("HamsterP",false));
        fish.setChecked(sp.getBoolean("FishP",false));

    }

}
