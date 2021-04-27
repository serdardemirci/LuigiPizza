package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.dao.abs.ToppingDal;
import com.serdardemirci.domain.Sauce;

import java.util.ArrayList;
import java.util.List;

public class InMemorySauceDal implements ToppingDal<Sauce> {

    List<Sauce> sauces = new ArrayList<>();

    public InMemorySauceDal() {
        sauces.add(new Sauce(1, "Tomatensauce", 0.0));
        sauces.add(new Sauce(2, "BBQ-Sauce", 0.0));
    }

    @Override
    public List<Sauce> getAll() {
        return sauces;
    }

    @Override
    public Sauce getById(int id) {
        return sauces.stream().filter(sauce -> sauce.id == id).findAny().orElse(null);
    }
}
