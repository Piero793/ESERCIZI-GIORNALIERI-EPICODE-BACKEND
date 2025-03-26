package it.epicode;

import it.epicode.classi.*;
import it.epicode.classi_DAO.EventoDao;
import it.epicode.classi_DAO.LocationDAO;
import it.epicode.classi_DAO.PartecipazioneDAO;
import it.epicode.classi_DAO.PersonaDAO;
import it.epicode.enums.Stato;
import it.epicode.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import static it.epicode.enums.Sesso.M;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDao eventoDao = new EventoDao(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);

        em.getTransaction().begin();

        Location location = new Location(null,"Stadio", "Via Roma");
        Location location2 = new Location(null, "Teatro", "Via Milano");
        Location location3 = new Location(null, "Cinema", "Via Napoli");
        locationDAO.save(location);
        locationDAO.save(location2);
        locationDAO.save(location3);

        Persona persona = new Persona(null, "Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1990, 1, 1), M);
        Persona persona2 = new Persona(null, "Luigi", "Verdi", "luigi.verdi@example.com", LocalDate.of(1995, 2, 2), M);
        Persona persona3 = new Persona(null, "Anna", "Bianchi", "anna.bianchi@example.com", LocalDate.of(1998, 3, 3), M);
        personaDAO.save(persona);
        personaDAO.save(persona2);
        personaDAO.save(persona3);

        Evento evento = new Evento(null, "Concerto", LocalDate.of(2024, 5, 20), "Concerto Rock", TipoEvento.PUBBLICO, 100, location, null);
        Evento evento2 = new Evento(null, "Concerto", LocalDate.of(2024, 5, 20), "Concerto Rock", TipoEvento.PUBBLICO, 100, location2, null);
        Evento evento3 = new Evento(null, "Concerto", LocalDate.of(2024, 5, 20), "Concerto Rock", TipoEvento.PUBBLICO, 100, location3, null);
        eventoDao.save(evento);
        eventoDao.save(evento2);
        eventoDao.save(evento3);

        Partecipazione partecipazione = new Partecipazione(null, persona, evento,Stato.CONFERMATO);
        Partecipazione partecipazione2 = new Partecipazione(null, persona2, evento2, Stato.DA_CONFERMARE);
        Partecipazione partecipazione3 = new Partecipazione(null, persona3, evento3, Stato.CONFERMATO);
        partecipazioneDAO.save(partecipazione);
        partecipazioneDAO.save(partecipazione2);
        partecipazioneDAO.save(partecipazione3);

        em.getTransaction().commit();

        emf.close();
        em.close();
    }
}
