package it.epicode.esercizio07_04.config;

import it.epicode.esercizio07_04.menu.Bevanda;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BevandaConfig {

    @Bean
    public Bevanda acqua() {
        return new Bevanda("Acqua", 3.0, 10);
    }

    @Bean
    public Bevanda cola() {
        return new Bevanda("Coca Cola", 5.0, 100);
    }

    @Bean
    public Bevanda birra() {
        return new Bevanda("Birra", 10.0, 100);
    }
}
