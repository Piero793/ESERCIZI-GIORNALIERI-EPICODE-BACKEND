package it.epicode.main;

import it.epicode.classi.Customer;
import it.epicode.classi.Order;
import it.epicode.classi.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static it.epicode.istanze.Istanze.orderList;

public class MainEsercizio1 {
    public static void main(String[] args) {

        String ordiniCliente = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer, Collectors.toList())).toString();
        System.out.println("-------------------------------");
         Map<Customer, List<Order>> ordiniPerCliente = orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
         ordiniPerCliente.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("--------------------------");
        System.out.println("Ordini per cliente");
        System.out.println(ordiniCliente);
        System.out.println("-------------------------------");

    }
}
