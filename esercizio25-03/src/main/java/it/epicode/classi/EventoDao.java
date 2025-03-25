package it.epicode.classi;

import jakarta.persistence.EntityManager;


public class EventoDao {
    private EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    // metodo con em per fare il find di un evento
    public Evento find(Long id) {
        return em.find(Evento.class, id);
    }

    // metodo con em per salvare un evento
    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    // metodo per eliminare un evento
    public void delete(Long id) {
        em.getTransaction().begin();
        Evento evento = find(id);
        em.remove(evento);
        em.getTransaction().commit();
    }

    // metodo per aggiornare un evento
    public void update(Evento evento) {
        em.getTransaction().begin();
        em.merge(evento);
        em.getTransaction().commit();
    }
}
