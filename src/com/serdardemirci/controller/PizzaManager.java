package com.serdardemirci.controller;

import com.serdardemirci.dao.abs.PizzaDal;
import com.serdardemirci.dao.concrete.inMemory.InMemoryPizzaDal;
import com.serdardemirci.domain.Pizza;

public class PizzaManager {

    PizzaDal pizzaDal;

    public PizzaManager() {
        pizzaDal = new InMemoryPizzaDal();
    }

    public Pizza getPizza() {
        return pizzaDal.get();
    }



}