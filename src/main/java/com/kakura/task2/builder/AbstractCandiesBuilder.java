package com.kakura.task2.builder;

import com.kakura.task2.entity.Candy;
import com.kakura.task2.exception.CandyException;

import java.util.HashSet;
import java.util.Set;

public abstract  class AbstractCandiesBuilder {
    protected Set<Candy> candies;

    public AbstractCandiesBuilder() {
        candies = new HashSet<Candy>();
    }

    public AbstractCandiesBuilder(Set<Candy> candies) {
        this.candies = candies;
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public abstract void buildSetCandies(String fileName) throws CandyException;
}
