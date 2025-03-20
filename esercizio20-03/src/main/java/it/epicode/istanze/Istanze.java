package it.epicode.istanze;

import it.epicode.classi.Customer;
import it.epicode.classi.Order;
import it.epicode.classi.Product;

import java.time.LocalDate;
import java.util.List;

public class Istanze {

    public static List<Product> productList = List.of(
            new Product(1L, "Calze", "Abbigliamento", 10.99),
            new Product(2L, "Bicicletta", "Giochi", 190.99),
            new Product(3L, "Iphone", "Elettronica", 999.99),
            new Product(4L, "Telecamera", "Elettronica", 290.99),
            new Product(5L, "Phon", "Capelli", 14.99)
    );

    public static List<Customer> customerList = List.of(
            new Customer(1L, "Luca", 1),
            new Customer(2L, "Giovanni", 2),
            new Customer(3L, "Maria", 3),
            new Customer(4L, "Francesco", 4),
            new Customer(5L, "Andrea", 5)
    );

    public static List<Order> orderList = List.of(
            new Order(1L, "In preparazione", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(0), productList.get(2)), customerList.get(0)),
            new Order(2L, "In preparazione", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(1), productList.get(3)), customerList.get(1)),
            new Order(3L, "In preparazione", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(2), productList.get(4)), customerList.get(2)),
            new Order(4L, "In preparazione", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(0), productList.get(1), productList.get(3)), customerList.get(3)),
            new Order(5L, "In preparazione", LocalDate.now(), LocalDate.now().plusDays(3), List.of(productList.get(4)), customerList.get(4))
    );

}
