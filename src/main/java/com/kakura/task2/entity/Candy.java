package com.kakura.task2.entity;

import java.time.YearMonth;

public abstract class Candy {
    protected long id;
    protected String name;
    protected YearMonth expirationDate;
    protected int energy;
    protected String type;
    protected Ingredients ingredients = new Ingredients();
    protected Value value = new Value();
    protected String production;

    public Candy() {

    }

    public Candy(long id, String name, YearMonth expirationDate, int energy, String type,
                 Ingredients ingredients, Value value, String production) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.energy = energy;
        this.type = type;
        this.ingredients = ingredients;
        this.value = value;
        this.production = production;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YearMonth getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(YearMonth expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Candy candy = (Candy) o;

        if (id != candy.id) return false;
        if (energy != candy.energy) return false;
        if (!name.equals(candy.name)) return false;
        if (expirationDate != null ? !expirationDate.equals(candy.expirationDate) : candy.expirationDate != null)
            return false;
        if (!type.equals(candy.type)) return false;
        if (!ingredients.equals(candy.ingredients)) return false;
        if (!value.equals(candy.value)) return false;
        return production.equals(candy.production);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + energy;
        result = 31 * result + type.hashCode();
        result = 31 * result + ingredients.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + production.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", expirationDate=").append(expirationDate);
        sb.append(", energy=").append(energy);
        sb.append(", type=").append(type);
        sb.append(", ingredients=").append(ingredients);
        sb.append(", value=").append(value);
        sb.append(", production='").append(production);
        sb.append("'");
        return sb.toString();
    }

}
