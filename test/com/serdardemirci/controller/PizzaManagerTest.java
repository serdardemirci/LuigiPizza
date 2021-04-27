package com.serdardemirci.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaManagerTest {
    private PizzaManager pizzaManager;

    @BeforeEach
    void setUp() {
        pizzaManager = new PizzaManager();
    }

    @Test
    void get_test_not_null() {
        assertNotNull(pizzaManager);
    }

    @Test
    void get_test_price(){
        assertEquals(4.99,pizzaManager.getPizza().price);
    }

}