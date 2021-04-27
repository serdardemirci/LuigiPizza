package com.serdardemirci.controller;

import com.serdardemirci.dao.abs.CartDal;
import com.serdardemirci.dao.concrete.inMemory.InMemoryCartDal;
import com.serdardemirci.dao.concrete.inMemory.InMemoryPizzaDal;
import com.serdardemirci.domain.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartManagerTest {
    private CartManager cartManager;
    private InMemoryPizzaDal pizzaDal;

    @BeforeEach
    void setUp() {
        cartManager = new CartManager();
        pizzaDal = new InMemoryPizzaDal();
    }

    @Test
    void addPizza() {
        cartManager.addPizza(pizzaDal.get());
        assertEquals(4.99, cartManager.get().pizzas.stream().findFirst().get().price);
    }

    @Test
    void get() {
        cartManager.addPizza(pizzaDal.get());
        cartManager.addPizza(pizzaDal.get());
        assertEquals(2, cartManager.get().pizzas.size());
    }
}