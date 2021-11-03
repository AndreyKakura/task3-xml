package com.kakura.task2.entity;

import java.util.List;

public class Ingredients {
    private int water;
    private int sugar;
    private int fructose;
    private int cocoa;
    private int vanillin;

    public Ingredients() {

    }

    public Ingredients(int water, int sugar, int fructose, int cocoa, int vanillin) {
        this.water = water;
        this.sugar = sugar;
        this.fructose = fructose;
        this.cocoa = cocoa;
        this.vanillin = vanillin;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public int getCocoa() {
        return cocoa;
    }

    public void setCocoa(int cocoa) {
        this.cocoa = cocoa;
    }

    public int getVanillin() {
        return vanillin;
    }

    public void setVanillin(int vanillin) {
        this.vanillin = vanillin;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "water=" + water +
                ", sugar=" + sugar +
                ", fructose=" + fructose +
                ", cocoa=" + cocoa +
                ", vanillin=" + vanillin +
                '}';
    }
}
