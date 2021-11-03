package com.kakura.task2.entity;

import java.time.YearMonth;

public class CaramelCandy extends Candy {
    private CaramelType caramelType;

    public CaramelCandy() {
        super();
    }

    public CaramelCandy(long id, String name, YearMonth expirationDate, int energy, String type,
                        Ingredients ingredients, Value value, String production, CaramelType caramelType) {
        super(id, name, expirationDate, energy, type, ingredients, value, production);
        this.caramelType = caramelType;
    }

    public CaramelType getCaramelType() {
        return caramelType;
    }

    public void setCaramelType(CaramelType caramelType) {
        this.caramelType = caramelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CaramelCandy that = (CaramelCandy) o;

        return caramelType == that.caramelType;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + caramelType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CaramelCandy{");
        sb.append(super.toString());
        sb.append(", caramelType=").append(caramelType.getValue());
        sb.append("}");
        return sb.toString();
    }
}
