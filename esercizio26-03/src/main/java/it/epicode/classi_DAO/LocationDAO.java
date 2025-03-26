package it.epicode.classi_DAO;

import it.epicode.classi.Location;
import jakarta.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    // metodo con em per fare il find di una location
    public Location getById(Long id) {
        return em.find(Location.class, id);
    }

    // metodo con em per fare il save di una location
    public void save(Location location) {
        em.persist(location);
    }

    // metodo con em per fare il delete di una location
    public void delete(Location location) {
        em.remove(location);

    }
    // metodo con em per fare l'update di una location
    public void update(Location location) {
        em.merge(location);
    }


}
