package it.epicode.main;

import it.epicode.classi.Customer;
import it.epicode.classi.Order;
import it.epicode.classi.Product;

import java.util.Map;
import java.util.stream.Collectors;

import static it.epicode.istanze.Istanze.orderList;

public class MainEsercizio2 {
    public static void main(String[] args) {
        Map<Customer, Double> totaleOrdiniPerCliente = orderList.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(order -> order.getProducts().stream()
                                .mapToDouble(Product::getPrice)
                                .sum()
                        )
                ));
        System.out.println("-------------------------------");
        System.out.println("Totale ordini per cliente");
        System.out.println(totaleOrdiniPerCliente);
    }
}
