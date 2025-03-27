package it.epicode.classi_DAO;

import it.epicode.classi.Concerto;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConcertoDAO {
    private EntityManager em;



    public void save(Concerto concerto) {
        em.persist(concerto);
    }

    public void delete(Long id) {
        Concerto concerto = em.find(Concerto.class, id);
        em.remove(concerto);
    }

    public Concerto findById(Long id) {
        return em.find(Concerto.class, id);
    }
}
