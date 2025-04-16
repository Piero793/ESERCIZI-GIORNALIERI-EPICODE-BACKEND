package it.epicode.esercizio15_04.autori;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public Page<Autore> findAll(Pageable pageable) {
        if (autoreRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Nessun autore trovato");
        }
        return autoreRepository.findAll(pageable);}

    public Autore findById(Long id) {
        return autoreRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Autore non trovato"));
    }

    public Autore create(Autore autore) {
        return autoreRepository.save(autore);
    }

    public Autore update(Long id, Autore autore) {
        Autore autoreToUpdate = findById(id);
        autoreToUpdate.setNome(autore.getNome());
        autoreToUpdate.setCognome(autore.getCognome());
        autoreToUpdate.setEmail(autore.getEmail());
        autoreToUpdate.setDataDiNascita(autore.getDataDiNascita());
        return autoreRepository.save(autoreToUpdate);
    }

    public void delete(Long id) {
        Autore autoreToDelete = findById(id);
        autoreRepository.delete(autoreToDelete);
    }
}
