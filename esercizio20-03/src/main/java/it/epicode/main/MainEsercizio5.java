package it.epicode.main;

import it.epicode.classi.Product;
import it.epicode.istanze.Istanze;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainEsercizio5 {

    public static List <Product> prodotti = Istanze.productList;

    public static void main(String[] args) {

        //raggruppa i prodotti per categoria
        Map<String, List<Product>> prodottiPerCategoria = prodotti.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        //calcolo la somma degli importi dei prodotti per categoria
        Map<String, Double> sommaPerCategoria = prodottiPerCategoria.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .mapToDouble(Product::getPrice)
                        .sum()));

        //stampa la somma degli importi dei prodotti per categoria
        System.out.println("Somma degli importi dei prodotti per categoria: ");
prodottiPerCategoria.forEach((categoria, prodotti) -> System.out.println(categoria + ": " + sommaPerCategoria.get(categoria)));}
}
