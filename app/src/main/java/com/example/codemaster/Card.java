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
        Boolean boolean1 = false, boolean2 = false, boolean3 = false, boolean4 = false;

        if(getColor1() == checkComputers[0]) {
            wright += 10;
            boolean1 = true;
        }
        if(getColor2() == checkComputers[1]) {
            wright += 10;
            boolean2 = true;
        }
        if(getColor3() == checkComputers[2]) {
            wright += 10;
            boolean3 = true;
        }
        if(getColor4() == checkComputers[3]) {
            wright += 10;
            boolean4 = true;
        }
        if(!boolean1){
            if(getColor2() == checkComputers[0] && !(getColor2() == checkComputers[1])) {
                wright ++;
            }else if(getColor3() == checkComputers[0] && !(getColor3() == checkComputers[2])) {
                wright ++;
            }else if(getColor4() == checkComputers[0] && !(getColor4() == checkComputers[3])) {
                wright++;
            }
        }
        if(!boolean2){
            if(getColor1() == checkComputers[1] && !(getColor1() == checkComputers[0])) {
                wright ++;
            }else if(getColor3() == checkComputers[1] && !(getColor3() == checkComputers[2])) {
                wright ++;
            }else if(getColor4() == checkComputers[1] && !(getColor4() == checkComputers[3])) {
                wright++;
            }
        }
        if(!boolean3){
            if(getColor1() == checkComputers[2] && !(getColor1() == checkComputers[0])) {
                wright ++;
            }else if(getColor2() == checkComputers[2] && !(getColor2() == checkComputers[1])) {
                wright ++;
            }else if(getColor4() == checkComputers[2] && !(getColor4() == checkComputers[3])) {
                wright++;
            }
        }
        if(!boolean4){
            if(getColor1() == checkComputers[3] && !(getColor1() == checkComputers[0])) {
                wright ++;
            }else if(getColor2() == checkComputers[3] && !(getColor2() == checkComputers[1])) {
                wright ++;
            }else if(getColor3() == checkComputers[3] && !(getColor3() == checkComputers[2])) {
                wright++;
            }
        }

        if(wright == 40){
            return "ניצחת";
        }

        return wright/10 + "בול\n" + wright%10 + "פגיעה";

    }

}