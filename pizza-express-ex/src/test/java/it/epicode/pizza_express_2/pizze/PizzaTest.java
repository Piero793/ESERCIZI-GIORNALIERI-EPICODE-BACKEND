package it.epicode.pizza_express_2.pizze;


import it.epicode.pizza_express_2.toppings.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootApplication
public class PizzaTest {

    @Autowired
    PizzaConfig pizzaConfig;
    @Autowired
    Topping topping;

    // test della creazione di una pizza
    @Test
    @DisplayName("Test creazione Pizza")
    public void testCreaPizza () {
        System.out.println("creo pizza");
        Pizza pizza = new Pizza ();
        pizza.setNome("Margherita");
        pizza.setDescrizione("Pomodoro, mozzarella");
        pizza.setPrezzo(4.99);
        pizza.setCalorie(1104);
        System.out.println("pizza creata");
    }
    // test per vedere se pizza margherita ha un costo di 4.99
    @Test
    @DisplayName("Test prezzo pizza margherita")
    public void testPrezzoPizzaMargherita () {
        System.out.println("creo pizza");
        Pizza pizza = new Pizza ();
        pizza.setNome("Margherita");
        pizza.setDescrizione("Pomodoro, mozzarella");
        pizza.setPrezzo(4.99);
        pizza.setCalorie(1104);
        System.out.println("pizza creata");
        System.out.println("prezzo pizza margherita: " + pizza.getPrezzo());
    }
    @Test
    @DisplayName("test creazione di un topping")
    public void testCreaTopping () {
        System.out.println("creo topping");
        Topping topping = new Topping();
        topping.setNome("cioccolato");
        topping.setCalorie(350);
        topping.setPrezzo(2.00);
        System.out.println("topping creato");
    }

    @ParameterizedTest
    @CsvSource({"Margherita, 4.99, 1104", "Diavola, 6.50, 1200", "Quattro Formaggi, 7.00, 1300"})
    void testPizzaAttribuiti(String nome, double prezzo, int calorie) {
        Pizza pizza = new Pizza();
        pizza.setNome(nome);
        pizza.setPrezzo(prezzo);
        pizza.setCalorie(calorie);

        assertEquals(nome, pizza.getNome(), "Nome errato");
        assertEquals(prezzo, pizza.getPrezzo(), "Prezzo errato");
        assertEquals(calorie, pizza.getCalorie(), "Calorie errate");
    }}






