/**
 * Homepage of the PETential app
 */

package com.example.petpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Home extends AppCompatActivity {

    /**
     * Displays app homepage
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /**
         * Calls openThirdActivity to open the recommended pet page from homepage when the recommended pets button is clicked
         */
        MaterialButton petbtn = (MaterialButton) findViewById(R.id.viewPets);
        petbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThirdActivity();
            }
        });


        /**
        * Calls openSecondActivity to open the profile page from homepage when the profile page button is clicked
        */
        MaterialButton profilebtn = (MaterialButton) findViewById(R.id.editProfile);
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openSecondActivity();
            }
        });

        /**
         * Calls openFourthActivity to open about our app page from homepage when the about button is clicked
         */
        MaterialButton aboutbtn = (MaterialButton) findViewById(R.id.AbOurApp);
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFourthActivity();
            }
        });
    }

    /**
     * Opens profile page
     */
    public void openSecondActivity(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    /**
     * Opens recommended pets page
     */
    public void openThirdActivity(){
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    /**
     * Opens about our app page
     */
    public void openFourthActivity(){
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

}