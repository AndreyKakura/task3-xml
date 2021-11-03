package com.kakura.task2.entity;

import java.time.YearMonth;

public class ChocolateCandy extends Candy {
    private boolean filling;

    public ChocolateCandy() {
        super();
    }

    public ChocolateCandy(long id, String name, YearMonth expirationDate, int energy, String type,
                          Ingredients ingredients, Value value, String production, boolean filling) {
        super(id, name, expirationDate, energy, type, ingredients, value, production);
        this.filling = filling;
    }

    public boolean isFilling() {
        return filling;
    }

    public void setFilling(boolean filling) {
        this.filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ChocolateCandy that = (ChocolateCandy) o;

        return filling == that.filling;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (filling ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChocolateCandy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", energy=" + energy +
                ", type='" + type + '\'' +
                ", ingredients=" + ingredients +
                ", value=" + value +
                ", production='" + production + '\'' +
                ", filling=" + filling +
                '}';
    }
}
