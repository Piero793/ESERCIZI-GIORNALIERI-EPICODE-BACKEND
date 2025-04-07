package it.epicode.esercizio07_04.config;

import it.epicode.esercizio07_04.menu.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfig {

    @Bean
    public Topping margheritaTopping() {
        return new Topping("Pomodoro, Mozzarella", 10.0, 100);
    }

    @Bean
    public Topping prosciuttoTopping() {
        return new Topping("Prosciutto", 10.0, 100);
    }

    @Bean
    public Topping salameTopping() {
        return new Topping("Salame", 10.0, 100);
    }
}