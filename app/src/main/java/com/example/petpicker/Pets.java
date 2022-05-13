package com.example.petpicker;

import android.content.SharedPreferences;

import java.util.*;

public class Pets {
    public LinkedHashMap<String, Double> petScores = new LinkedHashMap<String, Double>();
    public SharedPreferences sp;
    public int budget, time, sqft, age, size;
    public boolean Dog, Cat, Bird, Fish, Hamster;


    public Pets(SharedPreferences spIn)
    {
        sp = spIn;
        //Shared Preferences with values added
        petScores.put("Dog", 0.0);
        petScores.put("Cat", 0.0);
        petScores.put("Bird", 0.0);
        petScores.put("Hamster", 0.0);
        petScores.put("Fish", 0.0);

        budget = sp.getInt("budgetP",0);
        time = sp.getInt("timeP",0);
        sqft = sp.getInt("sqftP",0);
        age = sp.getInt("ageP",0);
        size = sp.getInt("sizeP",0);

        Dog = sp.getBoolean("DogP",false);
        Cat = sp.getBoolean("CatP",false);
        Bird = sp.getBoolean("BirdP",false);
        Fish = sp.getBoolean("FishP",false);
        Hamster = sp.getBoolean("HamsterP",false);

        //ArrayList of values based on research data and certain weight amounts added
        ArrayList<Integer> budgetA = new ArrayList<>();
        budgetA.add(Math.abs(100 -budget));
        budgetA.add(Math.abs(75 - budget));
        budgetA.add(Math.abs(30 - budget));
        budgetA.add(Math.abs(40 - budget));
        budgetA.add(Math.abs(50 - budget));
        int smallestDifference = Collections.min(budgetA);
        if (smallestDifference == budgetA.get(0))
        {
            petScores.put("Dog", petScores.get("Dog")+9);
        }
        if (smallestDifference == budgetA.get(1))
        {
            petScores.put("Cat", petScores.get("Cat")+9);
        }
        if (smallestDifference == budgetA.get(2))
        {
            petScores.put("Bird", petScores.get("Bird")+9);
        }
        if (smallestDifference == budgetA.get(3))
        {
            petScores.put("Hamster", petScores.get("Hamster")+9);
        }
        if (smallestDifference == budgetA.get(4))
        {
            petScores.put("Fish", petScores.get("Fish")+9);
        }

        ArrayList<Integer> timeA = new ArrayList<>();
        timeA.add(Math.abs(10 - time));
        timeA.add(Math.abs(4 - time));
        timeA.add(Math.abs(1 - time));
        timeA.add(Math.abs(3 - time));
        timeA.add(Math.abs(4 - time));
        int smallestDifference1 = Collections.min(timeA);
        if (smallestDifference1 == timeA.get(0))
        {
            petScores.put("Dog", petScores.get("Dog")+7);
        }
        if (smallestDifference1 == timeA.get(1))
        {
            petScores.put("Cat", petScores.get("Cat")+7);
        }
        if (smallestDifference1 == timeA.get(2))
        {
            petScores.put("Bird", petScores.get("Bird")+7);
        }
        if (smallestDifference1 == timeA.get(3))
        {
            petScores.put("Hamster", petScores.get("Hamster")+7);
        }
        if (smallestDifference1 == timeA.get(4))
        {
            petScores.put("Fish", petScores.get("Fish")+7);
        }

        ArrayList<Integer> sqftA = new ArrayList<>();
        sqftA.add(Math.abs(7700 - sqft));
        sqftA.add(Math.abs(2500 - sqft));
        sqftA.add(Math.abs(2 - sqft));
        sqftA.add(Math.abs(5 - sqft));
        sqftA.add(Math.abs(500 - sqft));
        int smallestDifference3 = Collections.min(sqftA);
        if (smallestDifference3 == sqftA.get(0))
        {
            petScores.put("Dog", petScores.get("Dog")+4);
        }
        if (smallestDifference3 == sqftA.get(1))
        {
            petScores.put("Cat", petScores.get("Cat")+4);
        }
        if (smallestDifference3 == sqftA.get(2))
        {
            petScores.put("Bird", petScores.get("Bird")+4);
        }
        if (smallestDifference3 == sqftA.get(3))
        {
            petScores.put("Hamster", petScores.get("Hamster")+4);
        }
        if (smallestDifference3 == sqftA.get(4))
        {
            petScores.put("Fish", petScores.get("Fish")+4);
        }

        ArrayList<Integer> ageA = new ArrayList<>();
        ageA.add(Math.abs(14 - age));
        ageA.add(Math.abs(13 - age));
        ageA.add(Math.abs(9 - age));
        ageA.add(Math.abs(10 - age));
        ageA.add(Math.abs(10 - age));
        int smallestDifference4 = Collections.min(ageA);
        if (smallestDifference4 == ageA.get(0))
        {
            petScores.put("Dog", petScores.get("Dog")+4);
        }
        if (smallestDifference4 == ageA.get(1))
        {
            petScores.put("Cat", petScores.get("Cat")+4);
        }
        if (smallestDifference4 == ageA.get(2))
        {
            petScores.put("Bird", petScores.get("Bird")+4);
        }
        if (smallestDifference4 == ageA.get(3))
        {
            petScores.put("Hamster", petScores.get("Hamster")+4);
        }
        if (smallestDifference4 == ageA.get(4))
        {
            petScores.put("Fish", petScores.get("Fish")+4);
        }

        ArrayList<Integer> sizeA = new ArrayList<>();
        sizeA.add(Math.abs(14 - size));
        sizeA.add(Math.abs(13 - size));
        sizeA.add(Math.abs(9 - size));
        sizeA.add(Math.abs(10 - size));
        sizeA.add(Math.abs(10 - size));
        int smallestDifference5 = Collections.min(sizeA);
        if (smallestDifference5 == sizeA.get(0))
        {
            petScores.put("Dog", petScores.get("Dog")+3);
        }
        if (smallestDifference5 == sizeA.get(1))
        {
            petScores.put("Cat", petScores.get("Cat")+3);
        }
        if (smallestDifference5 == sizeA.get(2))
        {
            petScores.put("Bird", petScores.get("Bird")+3);
        }
        if (smallestDifference5 == sizeA.get(3))
        {
            petScores.put("Hamster", petScores.get("Hamster")+3);
        }
        if (smallestDifference5 == sizeA.get(4))
        {
            petScores.put("Fish", petScores.get("Fish")+3);
        }

        if(!Dog)
        {
            petScores.put("Dog", petScores.get("Dog")*0.1);
        }
        if(!Cat)
        {
            petScores.put("Cat", petScores.get("Cat")*0.1);
        }
        if(!Bird)
        {
            petScores.put("Bird", petScores.get("Bird")*0.1);
        }
        if(!Hamster)
        {
            petScores.put("Hamster", petScores.get("Hamster")*0.1);
        }
        if(!Fish)
        {
            petScores.put("Fish", petScores.get("Fish")*0.1);
        }

        petScores = sortByValue(petScores);
    }

    public String getFirst() { return String.valueOf(petScores.keySet().toArray()[4]); }

    public String getSecond()
    {
        return String.valueOf(petScores.keySet().toArray()[3]);
    }

    public String getThird() { return String.valueOf(petScores.keySet().toArray()[2]); }

    public String getFourth()
    {
        return String.valueOf(petScores.keySet().toArray()[1]);
    }

    public String getFifth()
    {
        return String.valueOf(petScores.keySet().toArray()[0]);
    }

    // function to sort hashmap by values
    public static LinkedHashMap<String, Double> sortByValue(LinkedHashMap<String, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        LinkedHashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}
