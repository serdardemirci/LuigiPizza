package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.dao.abs.CartDal;
import com.serdardemirci.domain.Cart;
import com.serdardemirci.domain.Pizza;

public class InMemoryCartDal implements CartDal {

    Cart cart;

    public InMemoryCartDal() {
        cart = new Cart();
    }

    @Override
    public void addPizza(Pizza pizza) {
        cart.pizzas.add(pizza);
        updatePrice();
    }

    @Override
    public Cart get() {
        return cart;
    }

    private void updatePrice(){
        cart.price = cart.pizzas.stream().mapToDouble(pizza -> pizza.price).sum();
    }
}
