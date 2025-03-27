package it.epicode.classi_DAO;

import it.epicode.classi.Concerto;
import it.epicode.classi.Evento;
import it.epicode.enums.Genere;
import it.epicode.enums.Streaming;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventoDao  {
    private EntityManager em;


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

    // metodo JPQL per fare il getConertiInString di un evento true,false
    public void getConcertiInStreaming(Streaming inStreaming) {
        em.createQuery("SELECT e FROM Concerto e WHERE e.inStreaming = :inStreaming", Concerto.class)
                .setParameter("inStreaming", inStreaming)
                .getResultList();
    }


    // metodo JPQL per fare il getConcertiPerGenere dall enum Genere
    public void getConcertiPerGenere(Genere genere) {
        em.createQuery("SELECT e FROM Evento e WHERE e.genere = :genere", Evento.class)
                .setParameter("genere", genere)
                .getResultList();
    }
}
