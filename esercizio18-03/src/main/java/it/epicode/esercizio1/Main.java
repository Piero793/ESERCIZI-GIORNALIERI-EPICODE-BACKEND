package it.epicode.esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> paroleDistinte = new HashSet<>();
        Set<String> paroleDuplicate = new HashSet<>();

        System.out.print("Inserisci il numero di parole da inserire: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci ora le " + n + " parole:");
        for (int i = 0; i < n; i++) {
            System.out.print("Parola " + (i + 1) + ": ");
            String parola = scanner.nextLine();

            if (!paroleDistinte.add(parola)) {
                paroleDuplicate.add(parola);
            }
        }


        System.out.println("\n---- Parole Duplicate ----");
        if (paroleDuplicate.isEmpty()) {
            System.out.println("Nessuna parola duplicata trovata.");
        } else {
            for (String parola : paroleDuplicate) {
                System.out.println(parola);
            }
        }

        // Numero di parole distinte
        System.out.println("\nNumero di parole distinte: " + paroleDistinte.size());

        // Elenco delle parole distinte
        System.out.println("\n---- Parole Distinte ----");
        for (String parola : paroleDistinte) {
            System.out.println(parola);
        }

        scanner.close();
    }
}
