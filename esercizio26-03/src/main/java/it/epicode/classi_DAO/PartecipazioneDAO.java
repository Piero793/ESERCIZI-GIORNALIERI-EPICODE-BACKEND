package it.epicode.classi_DAO;

import it.epicode.classi.Partecipazione;
import jakarta.persistence.EntityManager;


public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    // metodo con em per fare il find di una partecipazione
    public Partecipazione find(Long id) {
        return em.find(Partecipazione.class, id);
    }

    // metodo con em per fare il save di una partecipazione
    public void save(Partecipazione partecipazione) {
        em.persist(partecipazione);
    }

    // metodo con em per fare il delete di una partecipazione
    public void delete(Long id) {
        Partecipazione partecipazione = find(id);
        em.remove(partecipazione);
    }

    // metodo con em per fare l'update di una partecipazione
    public void update(Partecipazione partecipazione) {
        em.merge(partecipazione);
    }
}
