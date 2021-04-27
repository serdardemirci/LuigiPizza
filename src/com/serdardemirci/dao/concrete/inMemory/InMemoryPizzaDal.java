package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.dao.abs.PizzaDal;
import com.serdardemirci.domain.Pizza;
import com.serdardemirci.domain.Sauce;
import com.serdardemirci.domain.Ingredient;

public class InMemoryPizzaDal implements PizzaDal {

    Pizza pizza;
    double pizzaPrice = 4.99; // Preis festgesetzt

    public InMemoryPizzaDal() {
        pizza = new Pizza();
        pizza.price = pizzaPrice;
    }

    @Override
    public Pizza get() {
        return pizza;
    }

    @Override
    public void addSauce(Sauce sauce) {
        pizza.sauce = sauce;
        updatePrice();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        pizza.ingredients.add(ingredient);
        updatePrice();
    }



    private void updatePrice(){
        double soucePrice = (pizza.sauce != null) ? pizza.sauce.price : 0;
        double ingredientPrice = (pizza.ingredients.size() > 0) ? pizza.ingredients.stream().mapToDouble(ingredient -> ingredient.price).sum() : 0;
        pizza.price = pizzaPrice + soucePrice + ingredientPrice;
    }
}
