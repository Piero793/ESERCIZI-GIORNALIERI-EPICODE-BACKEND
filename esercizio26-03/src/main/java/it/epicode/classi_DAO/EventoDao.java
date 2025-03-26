package it.epicode.classi_DAO;

import it.epicode.classi.Evento;
import jakarta.persistence.EntityManager;


public class EventoDao {
    private EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    // metodo con em per fare il find di un evento
    public Evento findById(Long id) {
        return em.find(Evento.class, id);
    }

    // metodo con em per salvare un evento
    public void save(Evento evento) {
        em.persist(evento);
    }

    // metodo per eliminare un evento
    public void delete(Long id) {
        Evento evento = findById(id);
        em.remove(evento);
    }

    // metodo per aggiornare un evento
    public void update(Evento evento) {
        em.merge(evento);
    }
}
