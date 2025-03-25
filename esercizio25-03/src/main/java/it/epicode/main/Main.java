package it.epicode.main;

import it.epicode.classi.Evento;
import it.epicode.classi.EventoDao;
import it.epicode.classi.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import static it.epicode.classi.TipoEvento.PRIVATO;
import static it.epicode.classi.TipoEvento.PUBBLICO;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDao eventoDao = new EventoDao(em);

        Evento evento = new Evento(null,"Ripassare Java", LocalDate.of(2025,04,20), "Ripassare per il venerdi",PRIVATO, 2);
        Evento evento1 = new Evento(null, "Portare il cane a spasso",LocalDate.now(), "Altrimenti si lamenta", PRIVATO, 2 );
        Evento evento2 = new Evento(null, "Cena con amici",LocalDate.of(2025,03,29), "La solita cena che finisce male ", PUBBLICO, 10 );
        Evento evento3 = new Evento(null, "Home gym",LocalDate.now(), "Sperando non ci sia nessuno", PRIVATO, 1 );

        // salvo gli eventi nel db

        eventoDao.save(evento);
        eventoDao.save(evento1);
        eventoDao.save(evento2);
        eventoDao.save(evento3);
        eventoDao.delete(2L);
        eventoDao.find(4L);
        Evento e = eventoDao.find(4L);
        System.out.println("Evento: "+ e.getTitolo() + " " + e.getDescrizione() + " " + e.getDataEvento()+ "" + e.getNumeroMassimoPartecipanti());

        em.close();
        emf.close();


    }

}
