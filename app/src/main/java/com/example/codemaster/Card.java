package com.example.codemaster;

import android.graphics.Color;

public class Card {

    int color1, color2, color3, color4;

    public Card(int color1, int color2, int color3, int color4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }

    public int getColor1() {
        return color1;
    }

    public void setColor1(int color1) {
        this.color1 = color1;
    }

    public int getColor2() {
        return color2;
    }

    public void setColor2(int color2) {
        this.color2 = color2;
    }

    public int getColor3() {
        return color3;
    }

    public void setColor3(int color3) {
        this.color3 = color3;
    }

    public int getColor4() {
        return color4;
    }

    public void setColor4(int color4) {
        this.color4 = color4;
    }

    public String getStrikes(){

        if (getColor1() == Color.RED && getColor2() == Color.BLUE && getColor3() == Color.GREEN && getColor4() == Color.YELLOW)
            return "you win";

        return "סתם משפט";
    }
}


