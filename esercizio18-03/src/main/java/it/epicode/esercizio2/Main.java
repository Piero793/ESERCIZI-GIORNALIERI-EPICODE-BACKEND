package it.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


       List<Integer> lista = new ArrayList<>();
        System.out.print("Inserisci un intero: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * 100);
            lista.add(num);
        }

        System.out.println("La lista ordinata di interi casuali da 0 a 100 è: " + lista);

        // funzione che ritorna gli elementi della prima lista in ordine inverso
        List<Integer> listaInversa = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInversa.add(lista.get(i));
        }

        System.out.println("La lista inversa è: " + listaInversa);

        List<Integer> listaPari = new ArrayList<>();
        List<Integer> listaDispari = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) {
                listaPari.add(lista.get(i));
            } else {
                listaDispari.add(lista.get(i));
            }
        }

        System.out.println("La lista dei numeri pari è: " + listaPari);
        System.out.println("La lista dei numeri dispari è: " + listaDispari);
    }
}
