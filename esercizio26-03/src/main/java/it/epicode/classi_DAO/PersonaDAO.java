package it.epicode.classi_DAO;

import it.epicode.classi.Persona;
import jakarta.persistence.EntityManager;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    // metodo con em per fare il find di una persona
    public Persona find(Long id) {
        return em.find(Persona.class, id);
    }

    // metodo con em per fare il save di una persona
    public void save(Persona persona) {
        em.persist(persona);
    }

    // metodo con em per fare il delete di una persona
    public void delete(Long id) {
        Persona persona = find(id);
        em.remove(persona);
    }

    // metodo con em per fare l'update di una persona
    public void update(Persona persona) {
        em.merge(persona);
    }
}
