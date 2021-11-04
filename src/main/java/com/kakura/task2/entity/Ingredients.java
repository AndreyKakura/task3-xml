package com.kakura.task2.entity;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredients that = (Ingredients) o;

        if (water != that.water) return false;
        if (sugar != that.sugar) return false;
        if (fructose != that.fructose) return false;
        if (cocoa != that.cocoa) return false;
        return vanillin == that.vanillin;
    }

    @Override
    public int hashCode() {
        int result = water;
        result = 31 * result + sugar;
        result = 31 * result + fructose;
        result = 31 * result + cocoa;
        result = 31 * result + vanillin;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ingredients{");
        sb.append("water=").append(water);
        sb.append(", sugar=").append(sugar);
        sb.append(", fructose=").append(fructose);
        sb.append(", cocoa=").append(cocoa);
        sb.append(", vanillin=").append(vanillin);
        sb.append('}');
        return sb.toString();
    }
}
