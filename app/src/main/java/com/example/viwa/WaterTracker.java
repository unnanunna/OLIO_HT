package com.example.viwa;

import org.json.JSONException;

public class WaterTracker {

    public double waterAmount;
    public int waterNeeded;
    public int totalWater = 0;
    private String weightString = "";
    private String exerciseString = "";
    private double weight;
    private double exercise;

    static WaterTracker instance = new WaterTracker();

    private WaterTracker(){

    }

    public static WaterTracker getInstance() {
        return instance;
    }


    EntryManager manager = new EntryManager();

    public int waterAmount() {
        //calculate the amount of water the user needs

        weightString = manager.getWeight();
        exerciseString = manager.getExercise();

        if (weightString != null && weightString.length() > 0) {
            try {
                weight = Double.parseDouble(weightString);
            } catch(Exception e) {
                 System.out.println("Empty string.");
            }
        }

        if (exerciseString != null && exerciseString.length() > 0) {
            try {
                exercise = Double.parseDouble(exerciseString);
            } catch(Exception e) {
                System.out.println("Empty string.");
            }
        }

        waterAmount = (weight * 0.033 + exercise * 24 * 0.0295735296) * 1000;
        waterNeeded = (int) Math.round(waterAmount);
        return waterNeeded;
    }

    public void waterAdd(int water) {
        if (totalWater < waterNeeded) {
            totalWater = totalWater + water;
            System.out.println("You have had " + totalWater + " ml water already today.");
        }
        else if (totalWater >= waterNeeded) {
            totalWater = totalWater + water;
            System.out.println("Congratulations, you already achieved your goal! You have had " + totalWater + " ml water today.");
        }
    }

    public int getWater() {
        return totalWater;
    }

}