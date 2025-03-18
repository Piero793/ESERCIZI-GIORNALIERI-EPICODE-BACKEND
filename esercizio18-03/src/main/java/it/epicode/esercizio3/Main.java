package it.epicode.esercizio3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RubricaTelefonica rubricaTelefonica = new RubricaTelefonica();
        Map<String, Integer> rubrica = new HashMap<>();

        rubrica.put("Luca", 3333333);
        rubrica.put("Giuseppe", 4444444);
        rubrica.put("Giorgia", 5555555);
        rubrica.put("Davide", 6666666);
        rubrica.put("Giovanna", 7777777);
        rubrica.put("Davide", 8888888);

        System.out.println(rubrica);

        System.out.println("elimino Giuseppe");
        rubrica.remove("Giuseppe");
        System.out.println(rubrica);

        System.out.println("controllo se contiene Giuseppe");
        System.out.println(rubrica.get("Giuseppe"));
        System.out.println("controllo se contiene Giorgia");
        System.out.println(rubrica.get("Giorgia"));

        System.out.println("controllo se contiene Giuseppe");
        System.out.println(rubrica.containsKey("Giuseppe"));
        System.out.println("controllo se contiene Giorgia");
        System.out.println(rubrica.containsKey("Giorgia"));

        System.out.println("controllo se contiene 6666666");
        System.out.println(rubrica.containsValue(6666666));
        System.out.println("controllo se contiene 5555555");
        System.out.println(rubrica.containsValue(5555555));

        System.out.println("controllo la dimensione della rubrica");
        System.out.println(rubrica.size());

        System.out.println("controllo se la rubrica è vuota");
        System.out.println(rubrica.isEmpty());

        rubrica.clear();

        System.out.println("controllo se la rubrica è vuota");
        System.out.println(rubrica.isEmpty());




    }
}
