/**
 * About our App page of the PETential app
 * @author rbaldawa28, amchong, ibateman
 */

package com.example.petpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class About extends AppCompatActivity {

    /**
     * Returns to the Home (homepage) when the back button on the device is pressed
     */
    public void onBackPressed() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    /**
     * Displays about our page title, information, and app logo
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
}