package com.serdardemirci.domain;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    public int id;
    public String name;
    public Sauce sauce;
    public List<Ingredient> ingredients = new ArrayList<>();
    public double price;

}
