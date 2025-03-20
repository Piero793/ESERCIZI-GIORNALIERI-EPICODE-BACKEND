package it.epicode.main;

import it.epicode.classi.Order;
import it.epicode.classi.Product;

import java.util.stream.Collectors;

import static it.epicode.istanze.Istanze.orderList;

public class MainEsercizio4 {
    public static void main(String[] args) {
        // Calcola la media degli importi degli ordini per cliente utilizzando Collectors.averagingDouble
        double mediaOrdini = orderList.stream()
                .collect(Collectors.averagingDouble(order -> order.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                        .sum()
                ));
        long mediaArrotondata = Math.round(mediaOrdini);

        System.out.println("Media degli importi degli ordini: " + mediaArrotondata);
    }
}
