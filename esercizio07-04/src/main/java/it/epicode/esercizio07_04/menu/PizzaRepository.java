package it.epicode.esercizio07_04.menu;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    // metodo per stampare tutte  le pizze
    void printAllPizze();

}
