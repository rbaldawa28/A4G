/**
 * The customizable edit user profile page of the PETential app.
 * @author rbaldawa28, amchong, ibateman
 */

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

    /**
     * Editable areas that allows user to input their information (text)
     */
    EditText name, budget, age, sqft, householdSize, time;

    /**
     * Selectable checkboxes for the different pet options and the user's interest
     */
    CheckBox dog, cat, bird, hamster, fish;

    /**
     * Submit/save user information button and viewMaps button
     */
    MaterialButton submit, viewOptions;

    /**
     * Returns to the Home (homepage) when the back button on the device is pressed
     */
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    /**
     * Displays editable profile page
     * @param savedInstanceState
     */
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
        viewOptions = findViewById(R.id.viewOptions);
        dog = findViewById(R.id.dog);
        cat = findViewById(R.id.cat);
        bird = findViewById(R.id.bird);
        hamster = findViewById(R.id.hamster);
        fish = findViewById(R.id.fish);

        /**
         * Opens options page with ordered pet ranking
         */
        viewOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOptions();
            }
        });


/**
 * Saves user's input when submit button is pressed and displays a message that confirms the profile was saved
 */
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
                editor.apply();
                Toast toast = Toast.makeText(getApplicationContext(), "Profile Saved", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    /**
     * Displays previously saved user information when the profile page is opened/reopened
     */
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

    /**
     * Method to open options class
     */
    public void openOptions()
    {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

}
