package it.epicode.classi_DAO;

import it.epicode.classi.PartitaDiCalcio;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PartitaDiCalcioDAO {
    private EntityManager em;



    public void save(PartitaDiCalcio partitaDiCalcio) {
        em.persist(partitaDiCalcio);
    }

    public void delete(Long id) {
        PartitaDiCalcio partitaDiCalcio = em.find(PartitaDiCalcio.class, id);
        em.remove(partitaDiCalcio);
    }

    public PartitaDiCalcio findById(Long id) {
        return em.find(PartitaDiCalcio.class, id);
    }
}
