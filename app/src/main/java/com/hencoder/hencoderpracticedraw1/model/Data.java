package com.hencoder.hencoderpracticedraw1.model;

/**
 * Created by heyangyang on 2017/10/24.
 */

public class Data {
    String name;
    float number;
    int color;

    public Data(String name, float number, int color){
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
