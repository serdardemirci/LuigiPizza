package com.serdardemirci.controller;

import com.serdardemirci.dao.abs.ToppingDal;
import com.serdardemirci.domain.Ingredient;
import com.serdardemirci.domain.Sauce;

import java.util.List;

public class ToppingService {
    ToppingDal<Sauce> sauceDal;
    ToppingDal<Ingredient> ingredientDal;

    public ToppingService(ToppingDal<Sauce> sauceDal, ToppingDal<Ingredient> ingredientDal){
        this.sauceDal = sauceDal;
        this.ingredientDal = ingredientDal;
    }


    public Ingredient getIngredientById(int ingredientId) {
        return ingredientDal.getById(ingredientId);
    }


    public Sauce getSauceById(int sauceId) {
        return sauceDal.getById(sauceId);
    }


    public List<Sauce> getAllSauces() {
        return sauceDal.getAll();
    }

    public List<Ingredient> getAllIngredients(){
        return ingredientDal.getAll();
    }

    public String addToppingToPizza(PizzaManager pizzaManager, int id) {
        if (pizzaManager.pizzaDal.get().ingredients.size() < 8) {
            Sauce sauce = getSauceById(id);
            if (sauce != null) {
                pizzaManager.pizzaDal.addSauce(sauce);
                return sauce.name + " wurde hinzugefügt!";
            }

            Ingredient ingredient = getIngredientById(id);
            if (ingredient != null) {
                pizzaManager.pizzaDal.addIngredient(ingredient);
                return ingredient.name + " wurde hinzugefügt!";
            }
        }
        else {
            return "Sie können maximal 8 Zutaten hinzufügen";
        }
        return "Falsche Eingabe";
    }
}
