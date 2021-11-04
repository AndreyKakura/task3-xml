package com.kakura.task2.entity;

public class Value {
    private int proteins;
    private int fats;
    private int carbohydrates;

    public Value() {

    }

    public Value(int proteins, int fats, int carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Value value = (Value) o;

        if (proteins != value.proteins) return false;
        if (fats != value.fats) return false;
        return carbohydrates == value.carbohydrates;
    }

    @Override
    public int hashCode() {
        int result = proteins;
        result = 31 * result + fats;
        result = 31 * result + carbohydrates;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Value{");
        sb.append("proteins=").append(proteins);
        sb.append(", fats=").append(fats);
        sb.append(", carbohydrates=").append(carbohydrates);
        sb.append("}");
        return sb.toString();
    }
}
