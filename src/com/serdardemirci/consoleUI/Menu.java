package com.serdardemirci.consoleUI;

import com.serdardemirci.controller.CartManager;
import com.serdardemirci.controller.PizzaManager;
import com.serdardemirci.controller.ToppingService;
import com.serdardemirci.dao.abs.ToppingDal;
import com.serdardemirci.dao.concrete.inMemory.InMemoryIngredientDal;
import com.serdardemirci.dao.concrete.inMemory.InMemorySauceDal;
import com.serdardemirci.domain.Ingredient;
import com.serdardemirci.domain.Sauce;

import java.util.Scanner;

public class Menu {
    CartManager cartManager;
    PizzaManager pizzaManager;
    ToppingDal<Ingredient> ingredientDal;
    ToppingDal<Sauce> sauceDal;
    ToppingService toppingService;
    int toppingId;

    public Menu(){
        cartManager = new CartManager();
        sauceDal = new InMemorySauceDal();
        ingredientDal = new InMemoryIngredientDal();
        toppingService = new ToppingService(sauceDal, ingredientDal);
    }

    void initMenu(){
        showMenu();
        Scanner scanner = new Scanner(System.in);

        getCommand(scanner);
    }

    public void getCommand(Scanner scanner) {
        do {
            System.out.println("Bitte geben Sie den gewünschten Befehl ein!");
            String command = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

            command = findToppingId(command);

            switch (command) {
                case "neuepizza":
                    createNewPizza();
                    break;

                case "zutatenliste" :
                    showToppingList();
                    break;

                case "fertig":
                    addPizzaToCart(scanner);
                    break;

                case "bestellunginfo":
                    cartInfo();
                    break;

                case "bestellen":
                    if (cartManager.get().pizzas.stream().findFirst().orElse(null) != null) {
                        cartInfo();
                        System.out.println("Sie können jetzt an der Kasse zahlen\n\n");
                        cartManager = new CartManager();
                        showMenu();
                    }
                    else{
                        System.out.println("Ihr Warenkorb ist noch leer!");
                    }
                    break;

                case "exit":
                    System.exit(0);
                    break;

                case "zutat" :
                    if (pizzaManager != null) {
                        System.out.println(toppingService.addToppingToPizza(pizzaManager, toppingId));
                    }
                    else {
                        pizzaNotImplementiert();
                    }
                    break;

                default:
                    incorrectInput();
                    break;
            }
        }while (true);
    }

    private void pizzaNotImplementiert() {
        System.out.println("Bitte erstellen Sie zuerst eine neue Pizza!");
    }

    private void incorrectInput() {
        System.out.println("Falsche Eingabe");
    }

    private void addPizzaToCart(Scanner scanner) {
        if (pizzaManager != null) {
            System.out.println("Bitte geben Sie einen Namen für Ihre Pizza :");
            pizzaManager.getPizza().name = scanner.nextLine();
            cartManager.addPizza(pizzaManager.getPizza());
            System.out.println("Ihre Pizza '" + pizzaManager.getPizza().name + "' wird der Bestellung hinzugefügt...");

        }
        else {
            System.out.println("Bitte erstellen Sie zuerst eine neue Pizza!");
        }
        pizzaManager = null;
    }

    private String findToppingId(String command) {
        if (command.contains("zutat")){
            try {
                toppingId = Integer.parseInt(command.substring(5));

                command = "zutat";
            }
            catch (Exception e){
                return command;
            }
        }
        return command;
    }

    private void showToppingList() {
        int i = 1;
        System.out.println("Soßen :");
        for (var sauce: toppingService.getAllSauces()){
            System.out.print(String.format("*  %2d  %-12.12s %.2f\t\t\t", sauce.id, sauce.name, sauce.price));
            if (i % 3 == 0){
                System.out.println();
            }
            i++;
        }
        System.out.println();
        i = 1;

        System.out.println("Zutaten :");
        for (var ingredient: toppingService.getAllIngredients()){
            System.out.print(String.format("*  %2d  %-12.12s %.2f\t\t\t", ingredient.id, ingredient.name,ingredient.price));
            if (i % 3 == 0) {
                System.out.println();
            }
            i++;
        }
        System.out.println();
    }

    public void createNewPizza() {
        System.out.println("Eine neue Pizza wird erstellt...");
        pizzaManager = new PizzaManager();
    }

    private void cartInfo() {
        String sauce;

        for (var pizza: cartManager.get().pizzas){
            sauce = pizza.sauce != null ? pizza.sauce.name : "hat keine Soße";

            System.out.print(String.format("Ihre Pizza '%s' %s",pizza.name,sauce));

            if (pizza.ingredients.size() != 0){
                for (var ingredient: pizza.ingredients){
                    System.out.print(String.format(", %s",ingredient.name));
                }
            }
            else {
                System.out.print(", hat keine Zutat(en)");
            }

            System.out.print(String.format(" und kostet € %.2f",pizza.price));

            System.out.println();
        }
        System.out.printf("Gesamtbetrag = € %.2f\n",cartManager.get().price);
        return;
    }

    private void showMenu() {
        System.out.println("Herzlich willkommen bei Luigis Pizza!");
        System.out.println("");
        System.out.println("Sie haben die Möglichkeit, aus den folgenden Befehlen zu wählen:");
        System.out.println("********************************************** Luigis-Pizza **********************************************");
        System.out.println("*  'Neue Pizza'                 - Startet das Erstellen einer Pizza.                                     *");
        System.out.println("*  'Zutatenliste'               - Zeigt Ihnen eine Liste aller Zutaten mit ihrer ID und ihrem Preis an.  *");
        System.out.println("*  'Zutat <id>' zb. Zutat 17    - Fügt die gewählte Zutat zur aktuellen Pizza hinzu.                     *");
        System.out.println("*  'Fertig'                     - Vollendet die aktuelle Pizza.                                          *");
        System.out.println("*  'Bestellung info'            - Zeigt den aktuellen Warenkorb an.                                      *");
        System.out.println("*  'Bestellen'                  - Schickt die Bestellung ab.                                             *");
        System.out.println("********************************************** Luigis-Pizza **********************************************");
        System.out.println("");
    }
}
