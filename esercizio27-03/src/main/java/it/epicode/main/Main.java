package it.epicode.main;

import it.epicode.classi.*;
import it.epicode.classi_DAO.EventoDao;
import it.epicode.classi_DAO.LocationDAO;
import it.epicode.classi_DAO.PartecipazioneDAO;
import it.epicode.classi_DAO.PersonaDAO;
import it.epicode.enums.Genere;
import it.epicode.enums.Streaming;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        // istanza delle classi DAO
        EventoDao eventoDao = new EventoDao(em);
        PersonaDAO personaDao = new PersonaDAO(em);
        LocationDAO locationDao = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO(em);

        // istanza delle partita di calcio usando il builder di lombok
        PartitaDiCalcio partitaDiCalcio = PartitaDiCalcio.builder()
                .squadraDiCasa("Inter")
                .squadraOspite("Milan")
                .squadraVincente("Inter")
                .golSquadraDiCasa(2)
                .golSquadraOspite(1)
                .build();

        // istanza di una gara di atletica
        GaraDiAtletica garaDiAtletica = GaraDiAtletica.builder()
                .titolo("Gara di atletica")
                .descrizione("Gara di atletica")
                .build();

        // istanza di un concerto usando il builder di lombok
        Concerto concerto = Concerto.builder()
                .genere(Genere.ROCK)
                .streaming(Streaming.TRUE)
                .build();

        // istanza di una persona usando il builder di lombok
        Persona persona = Persona.builder()
                .nome("Mario")
                .cognome("Rossi")
                .email("XXXXXXXXXXXXXXXXXXXXX")
                .build();

        // istanza di una persona usando il builder di lombok
        Persona persona2 = Persona.builder()
                .nome("Luigi")
                .cognome("Verdi")
                .email("XXXXXXXXXXXXXXXXXXXXX")
                .build();

        // istanza di una location usando il builder di lombok
        it.epicode.classi.Location location = it.epicode.classi.Location.builder()
                .citta("Milano")
                .nome("Stadio")
                .build();

        // istanza di una partecipazione usando il builder di lombok
        Partecipazione partecipazione = it.epicode.classi.Partecipazione.builder()
                .persona(persona)
                .evento(partitaDiCalcio)
                .build();

        // avvio transazione
        em.getTransaction().begin();

        // salvataggio di una persona
        personaDao.save(persona);
        // salvataggio di una persona
        personaDao.save(persona2);
        // salvataggio di un evento
        eventoDao.save(partitaDiCalcio);
        // salvataggio di un evento
        eventoDao.save(garaDiAtletica);
        // salvataggio di un evento
        eventoDao.save(concerto);
        // salvataggio di una location
        locationDao.save(location);
        // salvataggio di una partecipazione
        partecipazioneDao.save(partecipazione);

        em.getTransaction().commit();

       // richiamo il metodo getConcertiInStreaming
        List<Concerto> concertiStreaming = eventoDao.getConcertiInStreaming(Streaming.TRUE);
        System.out.println("Concerti in streaming:");
        for (Concerto c : concertiStreaming) {
            System.out.println(" - " + c.getTitolo() + " (" + c.getGenere() + ")");
        }

          // richiamo il metodo getConcertiPerGenere
        List<Concerto> concertiPerGenere = eventoDao.getConcertiPerGenere(Genere.ROCK);
        System.out.println("Concerti per genere ROCK:");
        for (Concerto c : concertiPerGenere) {
            System.out.println(" - " + c.getTitolo() + " (" + c.getStreaming() + ")");
        }

        // Richiamo getPartiteVinteInCasa
        List<PartitaDiCalcio> vinteInCasa = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class)
                .setParameter("citta", "Milano")
                .getResultList();

        System.out.println("Partite vinte in casa a Milano:");
        for (PartitaDiCalcio p : vinteInCasa) {
            System.out.println(" - " + p.getSquadraDiCasa() + " vs " + p.getSquadraOspite() + " (Vincitore: " + p.getSquadraVincente() + ")");
        }

        // Richiamo getPartiteVinteInTrasferta
        List<PartitaDiCalcio> vinteInTrasferta = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class)
                .setParameter("citta", "Milano")
                .getResultList();

        System.out.println("Partite vinte in trasferta a Milano:");
        for (PartitaDiCalcio p : vinteInTrasferta) {
            System.out.println(" - " + p.getSquadraDiCasa() + " vs " + p.getSquadraOspite() + " (Vincitore: " + p.getSquadraVincente() + ")");
        }


        // chiusura EntityManager e EntityManagerFactory
        em.close();
        emf.close();



    }

    }



