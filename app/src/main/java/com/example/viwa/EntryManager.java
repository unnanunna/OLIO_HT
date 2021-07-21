package com.example.viwa;

public class EntryManager {

    private String name = "";
    private String weight = "";
    private String exercise = "";


    User user = User.getInstance();

    public void saveEntry(String n, String w, String e) {
        user.setName(n);
        user.setWeight(w);
        user.setExercise(e);
    }

    public String getName() {
        name = user.getName();
        return name;
    }

    public String getWeight() {
        weight = user.getWeight();
        return weight;
    }

    public String getExercise() {
        exercise = user.getExercise();
        return exercise;
    }

}
