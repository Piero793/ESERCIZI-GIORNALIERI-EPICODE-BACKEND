package it.epicode.main;

import it.epicode.classi.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static it.epicode.istanze.Istanze.orderList;
import static it.epicode.istanze.Istanze.productList;

public class MainEsercizio3 {
    public static void main(String[] args) {

        List<Product> top3ProdottiCostosi = productList.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)
                .reversed())
                .limit(3)
                .toList();
        System.out.println("---------------------------------------");
        System.out.println("Top 3 prodotti più costosi:");
        top3ProdottiCostosi.forEach(System.out::println);
    }
}
