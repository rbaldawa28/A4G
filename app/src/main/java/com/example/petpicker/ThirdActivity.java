package com.example.petpicker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.*;


public class ThirdActivity extends AppCompatActivity {

    EditText pet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        MaterialButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstActivity();
            }
        });

        pet = findViewById(R.id.bestChoice);
        SharedPreferences sp = getSharedPreferences("UserPrefs",MODE_PRIVATE);

        ArrayList<String> pets = new ArrayList<String>(Arrays.asList("Dog","Cat","Bird","Hamster","Fish"));
        ArrayList<Double> scores = new ArrayList<Double>(Arrays.asList(0.5,0.4,0.3,0.2,0.1));

        if(sp.getInt("budgetP",0) >= 100)
        {
            scores.set(0,scores.get(0)+9); scores.set(1,scores.get(1)+9); scores.set(2,scores.get(2)+9); scores.set(3,scores.get(3)+9); scores.set(4,scores.get(4)+9);
        }
        else if(sp.getInt("budgetP",0) >= 75)
        {
            scores.set(1,scores.get(1)+9); scores.set(2,scores.get(2)+9); scores.set(3,scores.get(3)+9); scores.set(4,scores.get(4)+9);
        }
        else if(sp.getInt("budgetP",0) >= 50)
        {
            scores.set(2,scores.get(2)+9); scores.set(3,scores.get(3)+9); scores.set(4,scores.get(4)+9);
        }
        else if(sp.getInt("budgetP",0) >= 40)
        {
            scores.set(3,scores.get(3)+9); scores.set(4,scores.get(4)+9);
        }
        else if(sp.getInt("budgetP",0) >= 30)
        {
            scores.set(4,scores.get(4)+9);
        }

        if(sp.getInt("sqftP",0) >= 3000)
        {
            scores.set(0,scores.get(0)+6); scores.set(1,scores.get(1)+6); scores.set(2,scores.get(2)+6); scores.set(3,scores.get(3)+6); scores.set(4,scores.get(4)+6);
        }
        else if(sp.getInt("sqftP",0) >= 2000)
        {
            scores.set(1,scores.get(1)+6); scores.set(2,scores.get(2)+6); scores.set(3,scores.get(3)+6); scores.set(4,scores.get(4)+6);
        }
        else if(sp.getInt("sqftP",0) >= 500)
        {
            scores.set(2,scores.get(2)+6); scores.set(3,scores.get(3)+6); scores.set(4,scores.get(4)+6);
        }
        else if(sp.getInt("sqftP",0) >= 5)
        {
            scores.set(3,scores.get(3)+6); scores.set(4,scores.get(4)+6);
        }
        else if(sp.getInt("sqftP",0) >= 2)
        {
            scores.set(4,scores.get(4)+6);
        }

        if(sp.getInt("ageP",0) >= 16)
        {
            scores.set(0,scores.get(0)+4); scores.set(1,scores.get(1)+4); scores.set(2,scores.get(2)+4); scores.set(3,scores.get(3)+4); scores.set(4,scores.get(4)+4);
        }
        else if(sp.getInt("ageP",0) >= 15)
        {
            scores.set(1,scores.get(1)+4); scores.set(2,scores.get(2)+4); scores.set(3,scores.get(3)+4); scores.set(4,scores.get(4)+4);
        }
        else if(sp.getInt("ageP",0) >= 13)
        {
            scores.set(2,scores.get(2)+4); scores.set(3,scores.get(3)+4); scores.set(4,scores.get(4)+4);
        }
        else if(sp.getInt("ageP",0) >= 12)
        {
            scores.set(3,scores.get(3)+4); scores.set(4,scores.get(4)+4);
        }
        else if(sp.getInt("ageP",0) >= 9)
        {
            scores.set(4,scores.get(4)+4);
        }

        if(sp.getInt("householdSizeP",0) >= 5)
        {
            scores.set(0,scores.get(0)+2); scores.set(1,scores.get(1)+2); scores.set(2,scores.get(2)+2); scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("householdSizeP",0) >= 4)
        {
            scores.set(1,scores.get(1)+2); scores.set(2,scores.get(2)+2); scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("householdSizeP",0) >= 3)
        {
            scores.set(2,scores.get(2)+2); scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("householdSizeP",0) >= 2)
        {
            scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("householdSizeP",0) >= 1)
        {
            scores.set(4,scores.get(4)+2);
        }

        if(sp.getInt("timeP",0) >= 20)
        {
            scores.set(0,scores.get(0)+5); scores.set(1,scores.get(1)+5); scores.set(2,scores.get(2)+5); scores.set(3,scores.get(3)+5); scores.set(4,scores.get(4)+5);
        }
        else if(sp.getInt("timeP",0) >= 16)
        {
            scores.set(1,scores.get(1)+2); scores.set(2,scores.get(2)+2); scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("timeP",0) >= 8)
        {
            scores.set(2,scores.get(2)+2); scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("timeP",0) >= 7)
        {
            scores.set(3,scores.get(3)+2); scores.set(4,scores.get(4)+2);
        }
        else if(sp.getInt("timeP",0) >= 2)
        {
            scores.set(4,scores.get(4)+2);
        }

        if(!sp.getBoolean("dogP",false))
        {
            scores.set(0, 0.0);
        }
        if(!sp.getBoolean("catP",false))
        {
            scores.set(1, 0.0);
        }
        if(!sp.getBoolean("birdP",false))
        {
            scores.set(2, 0.0);
        }
        if(!sp.getBoolean("hamsterP",false))
        {
            scores.set(3, 0.0);
        }
        if(!sp.getBoolean("fishP",false))
        {
            scores.set(4, 0.0);
        }

        pet.setText(pets.get(scores.indexOf(Collections.max(scores))));
    }

    public void openFirstActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
