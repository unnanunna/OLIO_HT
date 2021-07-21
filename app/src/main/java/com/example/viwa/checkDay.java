package com.example.viwa;

public class checkDay {
    static checkDay instance = new checkDay();

    private checkDay(){

    }

    public static checkDay getInstance() {
        return instance;
    }

    private String check = "";
    private boolean clicked = false;

    public void setCheck(String b) {
        check = b;
    }

    public String getCheck() {
        return check;
    }

    public void setClicked (boolean b) {
        clicked = b;
    }

    public boolean getClicked () {
        return clicked;
    }
}
