package com.example.petpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialButton petbtn = (MaterialButton) findViewById(R.id.viewPets);
        petbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThirdActivity();
            }
        });



        MaterialButton profilebtn = (MaterialButton) findViewById(R.id.editProfile);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openSecondActivity();
            }
        });

        MaterialButton aboutbtn = (MaterialButton) findViewById(R.id.AbOurApp);
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourthActivity();
            }
        });
    }

    public void openSecondActivity(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void openThirdActivity(){
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    public void openFourthActivity(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

}