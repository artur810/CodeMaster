package com.example.codemaster;

import static com.example.codemaster.game.checkComputers;

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

    public String getStrikes() {

        int wright = 0;
        Boolean booleanComputer1 = false, booleanComputer2 = false, booleanComputer3 = false, booleanComputer4 = false;
        Boolean booleanCheck1 = false, booleanCheck2 = false, booleanCheck3 = false, booleanCheck4 = false;

        if(getColor1() == checkComputers[0]) {
            wright += 10;
            booleanComputer1 = true;
            booleanCheck1 = true;
        }
        if(getColor2() == checkComputers[1]) {
            wright += 10;
            booleanComputer2 = true;
            booleanCheck2 = true;
        }
        if(getColor3() == checkComputers[2]) {
            wright += 10;
            booleanComputer3 = true;
            booleanCheck3 = true;
        }
        if(getColor4() == checkComputers[3]) {
            wright += 10;
            booleanComputer4 = true;
            booleanCheck4 = true;
        }
        if(!booleanComputer1){
            if(getColor2() == checkComputers[0] && !booleanCheck2) {
                wright ++;
                booleanCheck2 = true;
            }else if(getColor3() == checkComputers[0] && !booleanCheck3) {
                wright ++;
                booleanCheck3 = true;
            }else if(getColor4() == checkComputers[0] && !booleanCheck4) {
                booleanCheck4 = true;
            }
        }
        if(!booleanComputer2){
            if(getColor1() == checkComputers[1] && !booleanCheck1) {
                wright ++;
                booleanCheck1 = true;
            }else if(getColor3() == checkComputers[1] && !booleanCheck3) {
                wright ++;
                booleanCheck3 = true;
            }else if(getColor4() == checkComputers[1] && !booleanCheck4) {
                wright++;
                booleanCheck4 = true;
            }
        }
        if(!booleanComputer3){
            if(getColor1() == checkComputers[2] && !booleanCheck1) {
                wright ++;
                booleanCheck1 = true;
            }else if(getColor2() == checkComputers[2] && !booleanCheck2) {
                wright ++;
                booleanCheck2 = true;
            }else if(getColor4() == checkComputers[2] && !booleanCheck4) {
                wright++;
                booleanCheck4 = true;
            }
        }
        if(!booleanComputer4){
            if(getColor1() == checkComputers[3] && !booleanCheck1) {
                wright ++;
                booleanCheck1 = true;
            }else if(getColor2() == checkComputers[3] && !booleanCheck2) {
                wright ++;
                booleanCheck2 = true;
            }else if(getColor3() == checkComputers[3] && !booleanCheck3) {
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