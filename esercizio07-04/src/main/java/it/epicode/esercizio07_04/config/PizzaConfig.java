package it.epicode.esercizio07_04.config;

import it.epicode.esercizio07_04.menu.Pizza;
import it.epicode.esercizio07_04.menu.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PizzaConfig {

    @Bean
    public Pizza pizzaMargherita(Topping margheritaTopping) {
        Pizza pizza = new Pizza();
        pizza.setName("Margherita");
        pizza.setPrice(10.0);
        pizza.setCalories(500);
        pizza.getToppings().add(margheritaTopping);
        return pizza;
    }

    @Bean
    public Pizza pizzaProsciutto(Topping margheritaTopping, Topping prosciuttoTopping) {
        Pizza pizza = new Pizza();
        pizza.setName("Prosciutto");
        pizza.setPrice(10.0);
        pizza.setCalories(500);
        pizza.getToppings().add(margheritaTopping);
        pizza.getToppings().add(prosciuttoTopping);
        return pizza;
    }

    @Bean
    public Pizza pizzaSalame(Topping margheritaTopping, Topping salameTopping) {
        Pizza pizza = new Pizza();
        pizza.setName("Salame");
        pizza.setPrice(10.0);
        pizza.setCalories(500);
        pizza.getToppings().add(margheritaTopping);
        pizza.getToppings().add(salameTopping);
        return pizza;
    }
}
