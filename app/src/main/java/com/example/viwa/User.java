package com.example.viwa;

public class User {

    static User instance = new User();

    private User(){

    }

    public static User getInstance() {
        return instance;
    }

    private String name = "";
    private String weight = "";
    private String exercise = "";

    public void setName(String s) {
        name = s;
    }

    public void setWeight(String w) {
        weight = w;
    }

    public void setExercise(String e) {
        exercise = e;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getExercise() {
        return exercise;
    }

}
