package it.epicode.classi_DAO;

import it.epicode.classi.Concerto;
import it.epicode.classi.Evento;
import it.epicode.enums.Genere;
import it.epicode.enums.Streaming;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import java.util.List;

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
    public List<Concerto> getConcertiInStreaming(Streaming streaming) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.streaming = :streaming", Concerto.class)
                .setParameter("streaming", streaming)
                .getResultList();
    }



    // metodo JPQL per fare il getConcertiPerGenere dall enum Genere
    public List<Concerto> getConcertiPerGenere(Genere genere) {
        return em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class)
                .setParameter("genere", genere)
                .getResultList();
    }

}
