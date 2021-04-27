package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.dao.abs.CartDal;
import com.serdardemirci.dao.abs.PizzaDal;
import com.serdardemirci.domain.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCartDalTest {
    private CartDal cartDal;
    private PizzaDal pizzaDal;

    @BeforeEach
    void setUp() {
        cartDal = new InMemoryCartDal();
        pizzaDal = new InMemoryPizzaDal();
    }

    @Test
    void addPizza() {
        cartDal.get().pizzas.add(pizzaDal.get());
        assertEquals(1,cartDal.get().pizzas.size());
    }

    @Test
    void get() {
        cartDal.addPizza(pizzaDal.get());
        cartDal.addPizza(pizzaDal.get());
        assertEquals(9.98, cartDal.get().price);
    }
}