package it.epicode.classi_DAO;

import it.epicode.classi.GaraDiAtletica;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GaraDiAtleticaDAO {
    private EntityManager em;



    public void save(GaraDiAtletica garaDiAtletica) {
        em.persist(garaDiAtletica);
    }

    public void delete(Long id) {
        GaraDiAtletica garaDiAtletica = em.find(GaraDiAtletica.class, id);
        em.remove(garaDiAtletica);
    }

    public GaraDiAtletica findById(Long id) {
        return em.find(GaraDiAtletica.class, id);
    }
}
