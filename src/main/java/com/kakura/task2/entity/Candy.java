package com.kakura.task2.entity;

import java.time.LocalDate;

public abstract class Candy {
    protected long id;
    protected String name;
    protected LocalDate expirationDate;
    protected int energy;
    protected String type;
    protected Ingredients ingredients;
    protected Value value;
    protected String production;
}
