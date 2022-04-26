package com.example.petpicker;

import android.content.SharedPreferences;

import java.util.*;

public class Pets {
    private HashMap<String, Double> petScores;
    private SharedPreferences sp;


    public Pets(SharedPreferences spIn)
    {
        sp = spIn;
        petScores.put("Dog", 0.0);
        petScores.put("Cat", 0.0);
        petScores.put("Bird", 0.0);
        petScores.put("Hamster", 0.0);
        petScores.put("Fish", 0.0);
    }
}
