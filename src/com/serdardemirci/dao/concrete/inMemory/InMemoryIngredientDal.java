package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.dao.abs.ToppingDal;
import com.serdardemirci.domain.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class InMemoryIngredientDal implements ToppingDal<Ingredient> {

    List<Ingredient> ingredients = new ArrayList<>();

    public InMemoryIngredientDal() {
        ingredients.add(new Ingredient(11, "Gouda",        0.99));
        ingredients.add(new Ingredient(12, "Mozzarella",   0.99));
        ingredients.add(new Ingredient(13, "Salami",       1.39));
        ingredients.add(new Ingredient(14, "Schinken",     1.39));
        ingredients.add(new Ingredient(15, "Thunfisch",    0.99));
        ingredients.add(new Ingredient(16, "Peperoni",     0.59));
        ingredients.add(new Ingredient(17, "Ananas",       0.59));
        ingredients.add(new Ingredient(18, "Mais",         0.59));
        ingredients.add(new Ingredient(19, "Zwiebeln",     0.59));
        ingredients.add(new Ingredient(20, "Oliven",       0.99));
        ingredients.add(new Ingredient(21, "Ei",           0.59));
        ingredients.add(new Ingredient(22, "Paprika",      0.59));
        ingredients.add(new Ingredient(23, "Tomaten",      0.59));
        ingredients.add(new Ingredient(24, "Champignons",  0.59));

    }


    @Override
    public List<Ingredient> getAll() {
        return ingredients;
    }

    @Override
    public Ingredient getById(int id) {
        return ingredients.stream().filter(ingredient -> ingredient.id == id).findAny().orElse(null);
    }


}
