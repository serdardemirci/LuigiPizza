package com.serdardemirci.controller;

import com.serdardemirci.dao.concrete.inMemory.InMemoryIngredientDal;
import com.serdardemirci.dao.concrete.inMemory.InMemorySauceDal;
import com.serdardemirci.domain.Ingredient;
import com.serdardemirci.domain.Sauce;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ToppingServiceTest {
    private PizzaManager pizzaManager;
    private InMemorySauceDal sauceDal;
    private InMemoryIngredientDal ingredientDal;
    private ToppingService toppingService;

    @BeforeEach
    void setUp(){
        pizzaManager = new PizzaManager();
        sauceDal = new InMemorySauceDal();
        ingredientDal = new InMemoryIngredientDal();
        toppingService = new ToppingService(sauceDal, ingredientDal);
    }

    @Test
    void getIngredientById() {
        assertEquals(11, toppingService.getIngredientById(11).id);
    }

    @Test
    void getSauceById() {
        assertEquals(1, toppingService.getSauceById(1).id);
    }

    @Test
    void getSauceById_with_dont_exists_id() {
        assertNull(toppingService.getSauceById(3));
    }

    @Test
    void getAllSauces() {
        assertEquals(2, toppingService.getAllSauces().size());
    }

    @Test
    void getAllIngredients() {
        assertEquals(14, toppingService.getAllIngredients().size());
    }

    @Test
    void addToppingToPizza() {
        toppingService.addToppingToPizza(pizzaManager, 1);
        Sauce sauce = new Sauce(1, "Tomatensauce", 0.0);
        assertEquals(sauce.id, pizzaManager.getPizza().sauce.id);
    }

    @Test
    void addToppingToPizza_max_ingredients(){
        String result = "";
        for (int i = 0; i < 9; i++) {
            result = toppingService.addToppingToPizza(pizzaManager,11);
        }
        assertEquals("Sie können maximal 8 Zutaten hinzufügen", result);
    }

    @Test
    void addToppingToPizza_incorrect_id(){
        String result = "";

        result = toppingService.addToppingToPizza(pizzaManager,30);

        assertEquals("Falsche Eingabe", result);
    }
}