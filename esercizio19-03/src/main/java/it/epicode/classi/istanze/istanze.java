package it.epicode.classi.istanze;

import it.epicode.classi.Customer;
import it.epicode.classi.Order;
import it.epicode.classi.Product;

import java.time.LocalDate;
import java.util.List;

public class istanze {

    public static List<Product> listaProdotti = List.of(
            new Product(1L, "Manuale", "Libri", 10.0),
            new Product(2L, "Call of Duty", "Video Game", 70.0),
            new Product(3L, "Apple Watch", "Elettronica", 500.0),
            new Product(4L, "Bicicletta", "Biciclette", 100.0),
            new Product(5L, "Pannolini", "Baby", 25.60),
            new Product(6L, "Bieberoni", "Baby", 8.60),
            new Product(7L, "Mutande", "Boys", 10.60),
            new Product(8L, "Scarpe", "Boys", 100.0)

    );


    public static List<Order> listaOrdini = List.of(
            new Order(1L, "In consegna", LocalDate.now(), LocalDate.now().plusDays(1), listaProdotti, new Customer(1L, "Giuseppe", 1)),
            new Order(2L, "In consegna", LocalDate.of(2021,2,3), LocalDate.of(2021,2,5), listaProdotti, new Customer(5L, "Pietro", 2)),
            new Order(3L, "In transito", LocalDate.of(2021,3,15), LocalDate.of(2021,4,10), listaProdotti, new Customer(4L, "Giovanni", 2)),
            new Order(4L, "In consegna", LocalDate.now(), LocalDate.now(), listaProdotti, new Customer(6L, "Alessandro", 3))
    );


}
