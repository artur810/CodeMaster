package com.example.codemaster;

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

    public int getColor2() {
        return color2;
    }

    public int getColor3() {
        return color3;
    }

    public int getColor4() {
        return color4;
    }

    public String getStrikes(int place1, int place2, int place3, int place4) {

        int wright = 0;
        boolean booleanComputer1 = false, booleanComputer2 = false, booleanComputer3 = false, booleanComputer4 = false;
        boolean booleanCheck1 = false, booleanCheck2 = false, booleanCheck3 = false, booleanCheck4 = false;

        if(getColor1() == place1) {
            wright += 10;
            booleanComputer1 = true;
            booleanCheck1 = true;
        }
        if(getColor2() == place2) {
            wright += 10;
            booleanComputer2 = true;
            booleanCheck2 = true;
        }
        if(getColor3() == place3) {
            wright += 10;
            booleanComputer3 = true;
            booleanCheck3 = true;
        }
        if(getColor4() == place4) {
            wright += 10;
            booleanComputer4 = true;
            booleanCheck4 = true;
        }
        if(!booleanComputer1){
            if(getColor2() == place1 && !booleanCheck2) {
                wright ++;
                booleanCheck2 = true;
            }else if(getColor3() == place1 && !booleanCheck3) {
                wright ++;
                booleanCheck3 = true;
            }else if(getColor4() == place1 && !booleanCheck4) {
                wright ++;
                booleanCheck4 = true;
            }
        }
        if(!booleanComputer2){
            if(getColor1() == place2 && !booleanCheck1) {
                wright ++;
                booleanCheck1 = true;
            }else if(getColor3() == place2 && !booleanCheck3) {
                wright ++;
                booleanCheck3 = true;
            }else if(getColor4() == place2 && !booleanCheck4) {
                wright++;
                booleanCheck4 = true;
            }
        }
        if(!booleanComputer3){
            if(getColor1() == place3 && !booleanCheck1) {
                wright ++;
                booleanCheck1 = true;
            }else if(getColor2() == place3 && !booleanCheck2) {
                wright ++;
                booleanCheck2 = true;
            }else if(getColor4() == place3 && !booleanCheck4) {
                wright++;
                booleanCheck4 = true;
            }
        }
        if(!booleanComputer4){
            if(getColor1() == place4 && !booleanCheck1) {
                wright ++;
                booleanCheck1 = true;
            }else if(getColor2() == place4 && !booleanCheck2) {
                wright ++;
                booleanCheck2 = true;
            }else if(getColor3() == place4 && !booleanCheck3) {
                wright++;
                booleanCheck3 = true;
            }
        }

        if(wright == 40){
            return "ניצחת";
        }

        return wright/10 + "בול\n" + wright%10 + "פגיעה";

    }

}