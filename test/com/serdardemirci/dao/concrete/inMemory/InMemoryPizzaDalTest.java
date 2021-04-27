package com.serdardemirci.dao.concrete.inMemory;

import com.serdardemirci.dao.abs.PizzaDal;
import com.serdardemirci.dao.abs.ToppingDal;
import com.serdardemirci.domain.Ingredient;
import com.serdardemirci.domain.Sauce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPizzaDalTest {
    private PizzaDal pizzaDal;
    private ToppingDal<Sauce> sauceDal;
    private ToppingDal<Ingredient> ingredientDal;

    @BeforeEach
    void setUp() {
        pizzaDal = new InMemoryPizzaDal();
        sauceDal = new InMemorySauceDal();
        ingredientDal = new InMemoryIngredientDal();
    }

    @Test
    void get() {
        assertNotNull(pizzaDal.get());
    }

    @Test
    void addSauce() {
        pizzaDal.addSauce(sauceDal.getById(1));
        assertEquals(1, pizzaDal.get().sauce.id);
    }

    @Test
    void addIngredient() {
        pizzaDal.addIngredient(ingredientDal.getById(11));
        assertEquals(1, pizzaDal.get().ingredients.size());
    }
}