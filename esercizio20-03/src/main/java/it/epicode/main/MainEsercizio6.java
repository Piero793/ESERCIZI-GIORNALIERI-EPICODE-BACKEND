package it.epicode.main;

import it.epicode.classi.Product;
import it.epicode.istanze.Istanze;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MainEsercizio6 {
    public static void salvaProdottiSuDisco(List<Product> prodotti, String filePath) {
        String contenuto = prodotti.stream()
                .map(p -> p.getName() + "@" + p.getCategory() + "@" + p.getPrice())
                .collect(Collectors.joining("#"));

        try {
            FileUtils.writeStringToFile(new File(filePath), contenuto, UTF_8);
            System.out.println("File salvato con successo: " + filePath);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {

        List<Product> prodotti = Istanze.productList;
        salvaProdottiSuDisco(prodotti, "prodotti.txt");

        System.out.println("File salvato con successo: prodotti.txt");}
}
