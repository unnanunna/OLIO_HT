package com.example.viwa;



public class VitaminRecommend {

    private int vitamins = 0;
    boolean result = false;

    static VitaminRecommend instance = new VitaminRecommend();

    private VitaminRecommend(){

    }

    public static VitaminRecommend getInstance() {
        return instance;
    }


    public void vitaminAdd() {

        if (vitamins == 0) {
            vitamins += 1;
            System.out.println("Congratulations, you have taken your vitamins today.");
        }
        else if (vitamins == 1) {
            System.out.println("You already had your vitamins today.");
        }
    }

    public int getVitamin() {
        return vitamins;
    }
}