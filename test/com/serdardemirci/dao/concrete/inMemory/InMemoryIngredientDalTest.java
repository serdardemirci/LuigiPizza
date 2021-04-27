package com.serdardemirci.dao.concrete.inMemory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryIngredientDalTest {
    private InMemoryIngredientDal ingredientDal;

    @BeforeEach
    void setUp() {
        ingredientDal = new InMemoryIngredientDal();
    }

    @Test
    void getAll() {
        assertEquals(14, ingredientDal.getAll().size());
    }

    @Test
    void getById() {
    }
}