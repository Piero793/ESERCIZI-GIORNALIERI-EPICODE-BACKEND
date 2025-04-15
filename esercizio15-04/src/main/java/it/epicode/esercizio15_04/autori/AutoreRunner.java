package it.epicode.esercizio15_04.autori;

import it.epicode.esercizio15_04.common.FackerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AutoreRunner implements CommandLineRunner {
    @Autowired
    private AutoreService autoriService;
    @Autowired
    private FackerConfig fakerService;
    @Override
    public void run(String... args) throws Exception {

        // creazione di 10 autori
        for (int i = 0; i < 10; i++) {
            Autore autore = new Autore();
            autore.setNome(fakerService.faker().name().firstName());
            autore.setCognome(fakerService.faker().name().lastName());
            autore.setEmail(fakerService.faker().internet().emailAddress());
            autore.setDataDiNascita(fakerService.faker().date().birthday().toString());
            autoriService.create(autore);
        }
    }
}
