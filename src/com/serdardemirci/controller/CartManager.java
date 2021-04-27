package com.serdardemirci.controller;

import com.serdardemirci.dao.abs.CartDal;
import com.serdardemirci.dao.concrete.inMemory.InMemoryCartDal;
import com.serdardemirci.domain.Cart;
import com.serdardemirci.domain.Pizza;


public class CartManager {

    CartDal cartDal;

    public CartManager(){
        cartDal = new InMemoryCartDal();
    }

    public void addPizza(Pizza pizza) {
        cartDal.addPizza(pizza);
    }

    public Cart get() {
        return cartDal.get();
    }

}
